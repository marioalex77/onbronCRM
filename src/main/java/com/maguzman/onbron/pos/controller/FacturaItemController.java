package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.beans.FacturaItem;
import com.maguzman.onbron.service.FacturaItemService;
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
public class FacturaItemController extends GenericController implements InterfaceController<FacturaItem> {
    private static final Logger logger = LogManager.getLogger(CategoriaController.class);

    public FacturaItemController(){
        System.out.println("FacturaItemController");
    }

    @Autowired
    private FacturaItemService facturaItemService;

    //Listar FacturaItems
    @RequestMapping(value = "/facturaItem", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model){
        logger.debug("listar() : FacturaItems");
        List<FacturaItem> listaFacturaItems= facturaItemService.buscarTodos();
        model.addObject("facturaItems", listaFacturaItems);
        model.setViewName("invoices/invoiceItems");
        return model;
    }

    //Guardar o actualizar Provedor
    @RequestMapping(value = "/facturaItem", method = RequestMethod.POST)
    public ModelAndView guardar(@Valid @ModelAttribute("facturaItem") FacturaItem facturaItem,
                                BindingResult result) {
        logger.debug("guardar() : {}", facturaItem);
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/invoices/add_invoiceItem");
            model.addObject("facturaItem", facturaItem);
            return model;
        }
        else {
            if (facturaItem.getIdFacturaItem() == 0) { // Si id es 0 se guarda nuevo registro
                // caso contrario se actualiza
                facturaItemService.salvar(facturaItem);
            } else {
                facturaItemService.actualizar(facturaItem);
            }
            return new ModelAndView("redirect:/facturaItem");
        }
    }

    //Mostrar formulario agregar categoria
    @RequestMapping(value = "/facturaItem/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        logger.debug("mostrarFormulario() FacturaItem");
        FacturaItem facturaItem = new FacturaItem();
        model.addObject("facturaItem", facturaItem);
        model.setViewName("/invoices/add_invoiceItem");
        return model;
    }

    //borrar categoria
    @RequestMapping(value = "/facturaItem/borrar", method = RequestMethod.GET)
    public ModelAndView borrar(HttpServletRequest request) {
        Integer facturaItemId = Integer.parseInt(request.getParameter("idFacturaItem"));
        logger.debug("borrar FacturaItem{}",facturaItemId);
        facturaItemService.borrar(facturaItemId);
        return new ModelAndView("redirect:/facturaItem");
    }

    //editar facturaItem
    @RequestMapping(value = "/facturaItem/editar", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        int facturaItemId = Integer.parseInt(request.getParameter("idFacturaItem"));
        FacturaItem facturaItem = facturaItemService.buscarPorClave(facturaItemId);
        logger.debug("Editar FacturaItem {}",facturaItem);
        ModelAndView model = new ModelAndView("/invoices/add_invoiceItem");
        model.addObject("facturaItem", facturaItem);
        return model;
    }

    //mostrar facturaItem
    @RequestMapping(value = "/facturaItem/mostrar", method = RequestMethod.GET)
    public ModelAndView mostrar(HttpServletRequest request){
        int facturaItemId = Integer.parseInt(request.getParameter("idFacturaItem"));
        FacturaItem facturaItem = facturaItemService.buscarPorClave(facturaItemId);
        logger.debug("Mostrar facturaItem {}",facturaItem);
        ModelAndView model = new ModelAndView("/invoices/show_invoiceItem");
        model.addObject("facturaItem", facturaItem);
        return model;
    }

    @ModelAttribute("loggedinuser")
    public String UsuarioLogeado(){
        return super.UsuarioLogeado();
    }
}
