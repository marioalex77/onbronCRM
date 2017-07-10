package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.beans.Factura;
import com.maguzman.onbron.service.FacturaService;
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
public class FacturaController extends GenericController implements InterfaceController<Factura>{
    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    @Autowired
    FacturaService facturaService;

    @RequestMapping(value = "/factura", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model) {
        logger.debug("listar() : Factura");
        List<Factura> listaFacturas= facturaService.buscarTodos();
        model.addObject("facturas", listaFacturas);
        model.setViewName("invoices/invoices");
        return model;
    }

    @RequestMapping(value = "/factura", method = RequestMethod.POST)
    public ModelAndView guardar(@ModelAttribute("factura")@Valid Factura factura, BindingResult result) {
        logger.debug("guardar() : {}", factura);
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/invoices/add_invoice");
            model.addObject("factura", factura);
            return model;
        }
        else{
            if (factura.getIdFactura() == 0) { // Si id es 0 se guarda nuevo registro
                // caso contrario se actualiza
                facturaService.salvar(factura);
            } else {
                facturaService.actualizar(factura);
            }
            return new ModelAndView("redirect:/factura");
        }
    }

    @RequestMapping(value = "/factura/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        logger.debug("mostrarFactura() Factura");
        Factura factura = new Factura();
        model.addObject("factura", factura);
        model.setViewName("/invoices/add_invoice");
        return model;
    }

    @RequestMapping(value = "/factura/borrar", method = RequestMethod.GET)
    public ModelAndView borrar(HttpServletRequest request) {
        Integer idFactura = Integer.parseInt(request.getParameter("idFactura"));
        logger.debug("borrar Factura{}",idFactura);
        facturaService.borrar(idFactura);
        return new ModelAndView("redirect:/factura");
    }

    @RequestMapping(value = "/factura/editar", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        int idFactura = Integer.parseInt(request.getParameter("idFactura"));
        Factura factura = facturaService.buscarPorClave(idFactura);
        logger.debug("Editar factura {}",factura);
        ModelAndView model = new ModelAndView("/invoices/add_invoice");
        model.addObject("factura", factura);
        return model;
    }

    @RequestMapping(value = "/factura/mostrar", method = RequestMethod.GET)
    public ModelAndView mostrar(HttpServletRequest request) {
        int idFactura = Integer.parseInt(request.getParameter("idFactura"));
        Factura factura = facturaService.buscarPorClave(idFactura);
        logger.debug("Mostrar factura {}",factura);
        ModelAndView model = new ModelAndView("/invoices/show_invoice");
        model.addObject("factura", factura);
        return model;
    }

    @ModelAttribute("loggedinuser")
    public String UsuarioLogeado(){
        return super.UsuarioLogeado();
    }
}
