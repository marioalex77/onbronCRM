package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.beans.Estado;
import com.maguzman.onbron.beans.Impuesto;
import com.maguzman.onbron.service.ImpuestoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Controller
public class ImpuestoController extends GenericController implements InterfaceController<Impuesto>{
    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    @Autowired
    ImpuestoService impuestoService;

    @RequestMapping(value = "/impuesto", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model) {
        logger.debug("listar() : Impuesto");
        List<Impuesto> listaImpuestos= impuestoService.buscarTodos();
        model.addObject("impuestos", listaImpuestos);
        model.setViewName("products/taxes");
        return model;
    }

    @RequestMapping(value = "/impuesto", method = RequestMethod.POST)
    public ModelAndView guardar(@ModelAttribute("impuesto")@Valid Impuesto impuesto, BindingResult result) {
        logger.debug("guardar() : {}", impuesto);
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/products/add_tax");
            model.addObject("impuesto", impuesto);
            return model;
        }
        else{
            if (impuesto.getIdImpuesto() == 0) { // Si id es 0 se guarda nuevo registro
                // caso contrario se actualiza
                impuestoService.salvar(impuesto);
            } else {
                impuestoService.actualizar(impuesto);
            }
            return new ModelAndView("redirect:/impuesto");
        }
    }

    @RequestMapping(value = "/impuesto/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        logger.debug("mostrarImpuesto() Impuesto");
        Impuesto impuesto = new Impuesto();
        model.addObject("impuesto", impuesto);
        model.setViewName("/products/add_tax");
        return model;
    }

    @RequestMapping(value = "/impuesto/borrar", method = RequestMethod.GET)
    public ModelAndView borrar(HttpServletRequest request) {
        Integer idImpuesto = Integer.parseInt(request.getParameter("idImpuesto"));
        logger.debug("borrar Impuesto{}",idImpuesto);
        impuestoService.borrar(idImpuesto);
        return new ModelAndView("redirect:/impuesto");
    }

    @RequestMapping(value = "/impuesto/editar", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        int idImpuesto = Integer.parseInt(request.getParameter("idImpuesto"));
        Impuesto impuesto = impuestoService.buscarPorClave(idImpuesto);
        logger.debug("Editar impuesto {}",impuesto);
        ModelAndView model = new ModelAndView("/impuesto/add_tax");
        model.addObject("impuesto", impuesto);
        return model;
    }

    @RequestMapping(value = "/impuesto/mostrar", method = RequestMethod.GET)
    public ModelAndView mostrar(HttpServletRequest request) {
        int idImpuesto = Integer.parseInt(request.getParameter("idImpuesto"));
        Impuesto impuesto = impuestoService.buscarPorClave(idImpuesto);
        logger.debug("Mostrar impuesto {}",impuesto);
        ModelAndView model = new ModelAndView("/products/show_tax");
        model.addObject("impuesto", impuesto);
        return model;
    }

    @ModelAttribute("estados")
    public LinkedHashMap<String,String> initEstados() {
        LinkedHashMap <String,String> estados = new LinkedHashMap<String,String>();
        estados.put(Estado.ACTIVO.getEstado(),Estado.ACTIVO.getName());
        estados.put(Estado.INACTIVO.getEstado(),Estado.INACTIVO.getName());
        estados.put(Estado.BLOQUEADO.getEstado(),Estado.BLOQUEADO.getName());
        estados.put(Estado.BORRADO.getEstado(),Estado.BLOQUEADO.getName());
        return estados;
    }

    @ModelAttribute("loggedinuser")
    public String UsuarioLogeado(){
        return super.UsuarioLogeado();
    }
}
