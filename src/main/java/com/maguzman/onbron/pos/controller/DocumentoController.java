package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.beans.Documento;
import com.maguzman.onbron.service.DocumentoService;
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
public class DocumentoController extends GenericController implements InterfaceController<Documento> {
    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    @Autowired
    DocumentoService documentoService;

    @RequestMapping(value = "/documento", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model) {
        logger.debug("listar() : Documentos");
        List<Documento> listaDocumentos = documentoService.buscarTodos();
        model.addObject("clientes", listaDocumentos);
        model.setViewName("products/documents");
        return model;
    }

    @RequestMapping(value = "/documento", method = RequestMethod.POST)
    public ModelAndView guardar(@ModelAttribute("documento") @Valid Documento documento, BindingResult result) {
        logger.debug("guardar() : {}", documento);
        if (result.hasErrors()) {
            ModelAndView model = new ModelAndView("/products/add_document");
            model.addObject("documento", documento);
            return model;
        } else {
            if (documento.getIdDocumento() == 0) { // Si id es 0 se guarda nuevo registro
                // caso contrario se actualiza
                documentoService.salvar(documento);
            } else {
                documentoService.actualizar(documento);
            }
            return new ModelAndView("redirect:/documento");
        }
    }

    @RequestMapping(value = "/documento/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        logger.debug("mostrarFormulario() Documento");
        Documento documento = new Documento();
        model.addObject("documento", documento);
        model.setViewName("/products/add_document");
        return model;
    }

    @RequestMapping(value = "/documento/borrar", method = RequestMethod.GET)
    public ModelAndView borrar(HttpServletRequest request) {
        Integer idDocumento = Integer.parseInt(request.getParameter("idDocumento"));
        logger.debug("borrar Documento{}", idDocumento);
        documentoService.borrar(idDocumento);
        return new ModelAndView("redirect:/documento");
    }

    @RequestMapping(value = "/documento/editar", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        int idDocumento = Integer.parseInt(request.getParameter("idDocumento"));
        Documento documento = documentoService.buscarPorClave(idDocumento);
        logger.debug("Editar Documento {}", documento);
        ModelAndView model = new ModelAndView("/cliente/add_document");
        model.addObject("documento", documento);
        return model;
    }

    @RequestMapping(value = "/documento/mostrar", method = RequestMethod.GET)
    public ModelAndView mostrar(HttpServletRequest request) {
        int idDocumento = Integer.parseInt(request.getParameter("idDocumento"));
        Documento documento = documentoService.buscarPorClave(idDocumento);
        logger.debug("Mostrar documento {}", documento);
        ModelAndView model = new ModelAndView("/products/show_document");
        model.addObject("documento", documento);
        return model;
    }

    @ModelAttribute("loggedinuser")
    public String UsuarioLogeado() {
        return super.UsuarioLogeado();
    }
}
