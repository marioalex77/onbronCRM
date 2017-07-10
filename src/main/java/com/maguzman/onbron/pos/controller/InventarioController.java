package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.beans.Inventario;
import com.maguzman.onbron.service.InventarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
public class InventarioController extends GenericController implements InterfaceController<Inventario>{
    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    @Autowired
    InventarioService inventarioService;

    @RequestMapping(value = "/inventario", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model) {
        logger.debug("listar() : Inventario");
        List<Inventario> listaInventarios= inventarioService.buscarTodos();
        model.addObject("inventarios", listaInventarios);
        model.setViewName("products/stocks");
        return model;
    }

    @RequestMapping(value = "/inventario", method = RequestMethod.POST)
    public ModelAndView guardar(@ModelAttribute("inventario")@Valid Inventario inventario, BindingResult result) {
        logger.debug("guardar() : {}", inventario);
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/products/add_stock");
            model.addObject("inventario", inventario);
            return model;
        }
        else{
            if (inventario.getIdInventario() == 0) { // Si id es 0 se guarda nuevo registro
                // caso contrario se actualiza
                inventarioService.salvar(inventario);
            } else {
                inventarioService.actualizar(inventario);
            }
            return new ModelAndView("redirect:/inventario");
        }
    }

    @RequestMapping(value = "/inventario/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        logger.debug("mostrarInventario() Inventario");
        Inventario inventario = new Inventario();
        model.addObject("inventario", inventario);
        model.setViewName("/products/add_stock");
        return model;
    }

    @RequestMapping(value = "/inventario/borrar", method = RequestMethod.GET)
    public ModelAndView borrar(HttpServletRequest request) {
        Integer idInventario = Integer.parseInt(request.getParameter("idInventario"));
        logger.debug("borrar Inventario{}",idInventario);
        inventarioService.borrar(idInventario);
        return new ModelAndView("redirect:/inventario");
    }

    @RequestMapping(value = "/inventario/editar", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        int idInventario = Integer.parseInt(request.getParameter("idInventario"));
        Inventario inventario = inventarioService.buscarPorClave(idInventario);
        logger.debug("Editar inventario {}",inventario);
        ModelAndView model = new ModelAndView("/products/add_stock");
        model.addObject("inventario", inventario);
        return model;
    }

    @RequestMapping(value = "/inventario/mostrar", method = RequestMethod.GET)
    public ModelAndView mostrar(HttpServletRequest request) {
        int idInventario = Integer.parseInt(request.getParameter("idInventario"));
        Inventario inventario = inventarioService.buscarPorClave(idInventario);
        logger.debug("Mostrar inventario {}",inventario);
        ModelAndView model = new ModelAndView("/products/show_stock");
        model.addObject("inventario", inventario);
        return model;
    }

    @ModelAttribute("loggedinuser")
    public String UsuarioLogeado(){
        return super.UsuarioLogeado();
    }
}

