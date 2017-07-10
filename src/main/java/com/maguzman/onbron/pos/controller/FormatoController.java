package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.beans.Formato;
import com.maguzman.onbron.service.FormatoService;
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
public class FormatoController extends GenericController implements InterfaceController<Formato>{
    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    @Autowired
    FormatoService formatoService;

    @RequestMapping(value = "/formato", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model) {
        logger.debug("listar() : Formato");
        List<Formato> listaFormatos= formatoService.buscarTodos();
        model.addObject("formatos", listaFormatos);
        model.setViewName("invoice/invformats");
        return model;
    }

    @RequestMapping(value = "/formato", method = RequestMethod.POST)
    public ModelAndView guardar(@ModelAttribute("formato")@Valid Formato formato, BindingResult result) {
        logger.debug("guardar() : {}", formato);
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/invoice/add_invformat");
            model.addObject("formato", formato);
            return model;
        }
        else{
            if (formato.getIdFormato() == 0) { // Si id es 0 se guarda nuevo registro
                // caso contrario se actualiza
                formatoService.salvar(formato);
            } else {
                formatoService.actualizar(formato);
            }
            return new ModelAndView("redirect:/formato");
        }
    }

    @RequestMapping(value = "/formato/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        logger.debug("mostrarFormato() Formato");
        Formato formato = new Formato();
        model.addObject("formato", formato);
        model.setViewName("/invoice/add_invformat");
        return model;
    }

    @RequestMapping(value = "/formato/borrar", method = RequestMethod.GET)
    public ModelAndView borrar(HttpServletRequest request) {
        Integer idFormato = Integer.parseInt(request.getParameter("idFormato"));
        logger.debug("borrar Formato{}",idFormato);
        formatoService.borrar(idFormato);
        return new ModelAndView("redirect:/formato");
    }

    @RequestMapping(value = "/formato/editar", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        int idFormato = Integer.parseInt(request.getParameter("idFormato"));
        Formato formato = formatoService.buscarPorClave(idFormato);
        logger.debug("Editar formato {}",formato);
        ModelAndView model = new ModelAndView("/invoice/add_invformat");
        model.addObject("formato", formato);
        return model;
    }

    @RequestMapping(value = "/formato/mostrar", method = RequestMethod.GET)
    public ModelAndView mostrar(HttpServletRequest request) {
        int idFormato = Integer.parseInt(request.getParameter("idFormato"));
        Formato formato = formatoService.buscarPorClave(idFormato);
        logger.debug("Mostrar formato {}",formato);
        ModelAndView model = new ModelAndView("/invoice/show_invformat");
        model.addObject("formato", formato);
        return model;
    }

    @ModelAttribute("loggedinuser")
    public String UsuarioLogeado(){
        return super.UsuarioLogeado();
    }
}
