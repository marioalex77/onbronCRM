package com.maguzman.onbron.pos.controller;

/**
 * Created by maguzman on 27/04/2017.
 */

import java.util.List;

import com.maguzman.onbron.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.maguzman.onbron.beans.Categoria;
import com.maguzman.onbron.service.CategoriaService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


@Controller
public class CategoriaController  extends GenericController implements InterfaceController<Categoria> {

    private static final Logger logger = LogManager.getLogger(CategoriaController.class);

    public CategoriaController(){
        super();
        System.out.println("CategoriaController");
    }

    @Autowired
    private CategoriaService categoriaService;

    //Listar Categorias
    @RequestMapping(value = "/categoria", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model){
        logger.debug("listar() : categorias");
        List<Categoria> listaCategorias= categoriaService.buscarTodos();
        model.addObject("categorias", listaCategorias);
        model.setViewName("products/categories");
        return model;
    }

    //Guardar o actualizar Usuario
    @RequestMapping(value = "/categoria", method = RequestMethod.POST)
    public ModelAndView guardar(@Valid @ModelAttribute("categoria") Categoria categoria,
                                               BindingResult result) {
        logger.debug("guardar() : {}", categoria);
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/products/add_categorie");
            model.addObject("categoria", categoria);
            return model;
        }
        else {
            if (categoria.getIdCategoria() == 0) { // Si id es 0 se guarda nuevo registro
                // caso contrario se actualiza
                categoriaService.salvar(categoria);
            } else {
                categoriaService.actualizar(categoria);
            }
            return new ModelAndView("redirect:/categoria");
        }
    }

    //Mostrar formulario agregar categoria
    @RequestMapping(value = "/categoria/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        logger.debug("mostrarFormulario() Categoria");
        Categoria categoria = new Categoria();
        model.addObject("categoria", categoria);
        model.setViewName("/products/add_categorie");
        return model;
    }

    //borrar categoria
    @RequestMapping(value = "/categoria/borrar", method = RequestMethod.GET)
    public ModelAndView borrar(HttpServletRequest request) {
        int categoriaId = Integer.parseInt(request.getParameter("idCategoria"));
        logger.debug("borrar() Categoria {}",categoriaId);
        categoriaService.borrar(categoriaId);
        return new ModelAndView("redirect:/categoria");
    }

    //editar categoria
    @RequestMapping(value = "/categoria/editar", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        int categoriaId = Integer.parseInt(request.getParameter("idCategoria"));
        Categoria categoria = categoriaService.buscarPorClave(categoriaId);
        logger.debug("editar(){}",categoria);
        ModelAndView model = new ModelAndView("/products/add_categorie");
        model.addObject("categoria", categoria);
        return model;
    }

    //mostrar categoria
    @RequestMapping(value = "/categoria/mostrar", method = RequestMethod.GET)
    public ModelAndView mostrar(HttpServletRequest request){
        int categoriaId = Integer.parseInt(request.getParameter("idCategoria"));
        Categoria categoria = categoriaService.buscarPorClave(categoriaId);
        logger.debug("mostrar() Categoria {}",categoria);
        ModelAndView model = new ModelAndView("/products/show_categorie");
        model.addObject("categoria", categoria);
        return model;
    }

    @ModelAttribute("loggedinuser")
    public String UsuarioLogeado(){
        return super.UsuarioLogeado();
    }

}
