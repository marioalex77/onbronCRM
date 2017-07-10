package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.beans.TipoFactura;
import com.maguzman.onbron.service.TipoFacturaService;
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
import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Controller
public class TipoFacturaController extends GenericController implements InterfaceController<TipoFactura>{
    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    @Autowired
    TipoFacturaService tipoFacturaService;

    @RequestMapping(value = "/tipoFactura", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model) {
        logger.debug("listar() : TipoFactura");
        List<TipoFactura> listaTipoFacturas= tipoFacturaService.buscarTodos();
        model.addObject("tipoFacturas", listaTipoFacturas);
        model.setViewName("settings/invoiceTypes");
        return model;
    }

    @RequestMapping(value = "/tipoFactura", method = RequestMethod.POST)
    public ModelAndView guardar(@ModelAttribute("tipoFactura")@Valid TipoFactura tipoFactura, BindingResult result) {
        logger.debug("guardar() : {}", tipoFactura);
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/settings/add_invoiceType");
            model.addObject("tipoFactura", tipoFactura);
            return model;
        }
        else{
            if (tipoFactura.getIdTipoFactura() == 0) { // Si id es 0 se guarda nuevo registro
                // caso contrario se actualiza
                tipoFacturaService.salvar(tipoFactura);
            } else {
                tipoFacturaService.actualizar(tipoFactura);
            }
            return new ModelAndView("redirect:/tipoFactura");
        }
    }

    @RequestMapping(value = "/tipoFactura/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        logger.debug("mostrarTipoFactura() TipoFactura");
        TipoFactura tipoFactura = new TipoFactura();
        model.addObject("tipoFactura", tipoFactura);
        model.setViewName("/settings/add_invoiceType");
        return model;
    }

    @RequestMapping(value = "/tipoFactura/borrar", method = RequestMethod.GET)
    public ModelAndView borrar(HttpServletRequest request) {
        Integer idTipoFactura = Integer.parseInt(request.getParameter("idTipoFactura"));
        logger.debug("borrar TipoFactura{}",idTipoFactura);
        tipoFacturaService.borrar(idTipoFactura);
        return new ModelAndView("redirect:/tipoFactura");
    }

    @RequestMapping(value = "/tipoFactura/editar", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        int idTipoFactura = Integer.parseInt(request.getParameter("idTipoFactura"));
        TipoFactura tipoFactura = tipoFacturaService.buscarPorClave(idTipoFactura);
        logger.debug("Editar tipoFactura {}",tipoFactura);
        ModelAndView model = new ModelAndView("/settings/add_invoiceType");
        model.addObject("tipoFactura", tipoFactura);
        return model;
    }

    @RequestMapping(value = "/tipoFactura/mostrar", method = RequestMethod.GET)
    public ModelAndView mostrar(HttpServletRequest request) {
        int idTipoFactura = Integer.parseInt(request.getParameter("idTipoFactura"));
        TipoFactura tipoFactura = tipoFacturaService.buscarPorClave(idTipoFactura);
        logger.debug("Mostrar tipoFactura {}",tipoFactura);
        ModelAndView model = new ModelAndView("/settings/show_invoiceType");
        model.addObject("tipoFactura", tipoFactura);
        return model;
    }

    @ModelAttribute("loggedinuser")
    public String UsuarioLogeado(){
        return super.UsuarioLogeado();
    }
}


