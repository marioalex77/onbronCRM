package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.beans.TipoPago;
import com.maguzman.onbron.service.TipoPagoService;
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
public class TipoPagoController extends GenericController implements InterfaceController<TipoPago>{
    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    @Autowired
    TipoPagoService tipoPagoService;

    @RequestMapping(value = "/tipoPago", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model) {
        logger.debug("listar() : TipoPago");
        List<TipoPago> listaTipoPagos= tipoPagoService.buscarTodos();
        model.addObject("tipoPagos", listaTipoPagos);
        model.setViewName("settings/paymentTypes");
        return model;
    }

    @RequestMapping(value = "/tipoPago", method = RequestMethod.POST)
    public ModelAndView guardar(@ModelAttribute("tipoPago")@Valid TipoPago tipoPago, BindingResult result) {
        logger.debug("guardar() : {}", tipoPago);
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/settings/add_paymentType");
            model.addObject("tipoPago", tipoPago);
            return model;
        }
        else{
            if (tipoPago.getIdTipoPago() == 0) { // Si id es 0 se guarda nuevo registro
                // caso contrario se actualiza
                tipoPagoService.salvar(tipoPago);
            } else {
                tipoPagoService.actualizar(tipoPago);
            }
            return new ModelAndView("redirect:/tipoPago");
        }
    }

    @RequestMapping(value = "/tipoPago/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        logger.debug("mostrarTipoPago() TipoPago");
        TipoPago tipoPago = new TipoPago();
        model.addObject("tipoPago", tipoPago);
        model.setViewName("/settings/add_paymentType");
        return model;
    }

    @RequestMapping(value = "/tipoPago/borrar", method = RequestMethod.GET)
    public ModelAndView borrar(HttpServletRequest request) {
        Integer idTipoPago = Integer.parseInt(request.getParameter("idTipoPago"));
        logger.debug("borrar TipoPago{}",idTipoPago);
        tipoPagoService.borrar(idTipoPago);
        return new ModelAndView("redirect:/tipoPago");
    }

    @RequestMapping(value = "/tipoPago/editar", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        int idTipoPago = Integer.parseInt(request.getParameter("idTipoPago"));
        TipoPago tipoPago = tipoPagoService.buscarPorClave(idTipoPago);
        logger.debug("Editar tipoPago {}",tipoPago);
        ModelAndView model = new ModelAndView("/settings/add_paymentType");
        model.addObject("tipoPago", tipoPago);
        return model;
    }

    @RequestMapping(value = "/tipoPago/mostrar", method = RequestMethod.GET)
    public ModelAndView mostrar(HttpServletRequest request) {
        int idTipoPago = Integer.parseInt(request.getParameter("idTipoPago"));
        TipoPago tipoPago = tipoPagoService.buscarPorClave(idTipoPago);
        logger.debug("Mostrar tipoPago {}",tipoPago);
        ModelAndView model = new ModelAndView("/settings/show_paymentType");
        model.addObject("tipoPago", tipoPago);
        return model;
    }

    @ModelAttribute("loggedinuser")
    public String UsuarioLogeado(){
        return super.UsuarioLogeado();
    }
}

