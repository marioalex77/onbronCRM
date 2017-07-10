package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.beans.Pago;
import com.maguzman.onbron.service.PagoService;
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
public class PagoController extends GenericController implements InterfaceController<Pago>{
    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    @Autowired
    PagoService pagoService;

    @RequestMapping(value = "/pago", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model) {
        logger.debug("listar() : Pago");
        List<Pago> listaPagos= pagoService.buscarTodos();
        model.addObject("pagos", listaPagos);
        model.setViewName("sales/sales");
        return model;
    }

    @RequestMapping(value = "/pago", method = RequestMethod.POST)
    public ModelAndView guardar(@ModelAttribute("pago")@Valid Pago pago, BindingResult result) {
        logger.debug("guardar() : {}", pago);
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/sales/add_sale");
            model.addObject("pago", pago);
            return model;
        }
        else{
            if (pago.getIdpago() == 0) { // Si id es 0 se guarda nuevo registro
                // caso contrario se actualiza
                pagoService.salvar(pago);
            } else {
                pagoService.actualizar(pago);
            }
            return new ModelAndView("redirect:/pago");
        }
    }

    @RequestMapping(value = "/pago/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        logger.debug("mostrarPago() Pago");
        Pago pago = new Pago();
        model.addObject("pago", pago);
        model.setViewName("/sales/add_sale");
        return model;
    }

    @RequestMapping(value = "/pago/borrar", method = RequestMethod.GET)
    public ModelAndView borrar(HttpServletRequest request) {
        Integer idPago = Integer.parseInt(request.getParameter("idPago"));
        logger.debug("borrar Pago{}",idPago);
        pagoService.borrar(idPago);
        return new ModelAndView("redirect:/pago");
    }

    @RequestMapping(value = "/pago/editar", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        int idPago = Integer.parseInt(request.getParameter("idPago"));
        Pago pago = pagoService.buscarPorClave(idPago);
        logger.debug("Editar pago {}",pago);
        ModelAndView model = new ModelAndView("/sales/add_sale");
        model.addObject("pago", pago);
        return model;
    }

    @RequestMapping(value = "/pago/mostrar", method = RequestMethod.GET)
    public ModelAndView mostrar(HttpServletRequest request) {
        int idPago = Integer.parseInt(request.getParameter("idPago"));
        Pago pago = pagoService.buscarPorClave(idPago);
        logger.debug("Mostrar pago {}",pago);
        ModelAndView model = new ModelAndView("/sales/show_sale");
        model.addObject("pago", pago);
        return model;
    }

    @ModelAttribute("loggedinuser")
    public String UsuarioLogeado(){
        return super.UsuarioLogeado();
    }
}

