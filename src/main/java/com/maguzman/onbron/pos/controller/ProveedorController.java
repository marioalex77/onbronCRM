package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.beans.Proveedor;
import com.maguzman.onbron.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
@Controller
public class ProveedorController extends GenericController implements InterfaceController<Proveedor> {
    private static final Logger logger = LogManager.getLogger(CategoriaController.class);

    public ProveedorController(){
        System.out.println("ProveedorController");
    }

    @Autowired
    private ProveedorService proveedorService;

    //Listar Proveedores
    @RequestMapping(value = "/proveedor", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model){
        logger.debug("listar() : Proveedores");
        List<Proveedor> listaProveedores= proveedorService.buscarTodos();
        model.addObject("proveedores", listaProveedores);
        model.setViewName("products/providers");
        return model;
    }

    //Guardar o actualizar Provedor
    @RequestMapping(value = "/proveedor", method = RequestMethod.POST)
    public ModelAndView guardar(@Valid @ModelAttribute("proveedor") Proveedor proveedor,
                                         BindingResult result) {
        logger.debug("guardar() : {}", proveedor);
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/products/add_provider");
            model.addObject("proveedor", proveedor);
            return model;
        }
        else {
            if (proveedor.getIdProveedor() == 0) { // Si id es 0 se guarda nuevo registro
                // caso contrario se actualiza
                proveedorService.salvar(proveedor);
            } else {
                proveedorService.actualizar(proveedor);
            }
            return new ModelAndView("redirect:/proveedor");
        }
    }

    //Mostrar formulario agregar categoria
    @RequestMapping(value = "/proveedor/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        logger.debug("mostrarFormulario() Proveedor");
        Proveedor proveedor = new Proveedor();
        model.addObject("proveedor", proveedor);
        model.setViewName("/products/add_provider");
        return model;
    }

    //borrar categoria
    @RequestMapping(value = "/proveedor/borrar", method = RequestMethod.GET)
    public ModelAndView borrar(HttpServletRequest request) {
        Integer proveedorId = Integer.parseInt(request.getParameter("idProveedor"));
        logger.debug("borrar Proveedor{}",proveedorId);
        proveedorService.borrar(proveedorId);
        return new ModelAndView("redirect:/proveedor");
    }

    //editar proveedor
    @RequestMapping(value = "/proveedor/editar", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        int proveedorId = Integer.parseInt(request.getParameter("idProveedor"));
        Proveedor proveedor = proveedorService.buscarPorClave(proveedorId);
        logger.debug("Editar Proveedor {}",proveedor);
        ModelAndView model = new ModelAndView("/products/add_provider");
        model.addObject("proveedor", proveedor);
        return model;
    }

    //mostrar proveedor
    @RequestMapping(value = "/proveedor/mostrar", method = RequestMethod.GET)
    public ModelAndView mostrar(HttpServletRequest request){
        int proveedorId = Integer.parseInt(request.getParameter("idProveedor"));
        Proveedor proveedor = proveedorService.buscarPorClave(proveedorId);
        logger.debug("Mostrar proveedor {}",proveedor);
        ModelAndView model = new ModelAndView("/products/show_provider");
        model.addObject("proveedor", proveedor);
        return model;
    }

    @ModelAttribute("loggedinuser")
    public String UsuarioLogeado(){
        return super.UsuarioLogeado();
    }
}
