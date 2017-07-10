package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.beans.Cliente;
import com.maguzman.onbron.service.ClienteService;
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
public class ClienteController extends GenericController implements InterfaceController<Cliente>{
    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    @Autowired
    ClienteService clienteService;

    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model) {
        logger.debug("listar() : Clientes");
        List<Cliente> listaClientes= clienteService.buscarTodos();
        model.addObject("clientes", listaClientes);
        model.setViewName("products/customers");
        return model;
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public ModelAndView guardar(@ModelAttribute("cliente")@Valid Cliente cliente, BindingResult result) {
        logger.debug("guardar() : {}", cliente);
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/customer/add_customer");
            model.addObject("cliente", cliente);
            return model;
        }
        else{
            if (cliente.getIdCliente() == 0) { // Si id es 0 se guarda nuevo registro
                // caso contrario se actualiza
                clienteService.salvar(cliente);
            } else {
                clienteService.actualizar(cliente);
            }
            return new ModelAndView("redirect:/cliente");
        }
    }

    @RequestMapping(value = "/cliente/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        logger.debug("mostrarFormulario() Documento");
        Cliente cliente = new Cliente();
        model.addObject("cliente", cliente);
        model.setViewName("/customer/add_customer");
        return model;
    }

    @RequestMapping(value = "/cliente/borrar", method = RequestMethod.GET)
    public ModelAndView borrar(HttpServletRequest request) {
        Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
        logger.debug("borrar Cliente{}",idCliente);
        clienteService.borrar(idCliente);
        return new ModelAndView("redirect:/cliente");
    }

    @RequestMapping(value = "/cliente/editar", method = RequestMethod.GET)
    public ModelAndView editar(HttpServletRequest request) {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = clienteService.buscarPorClave(idCliente);
        logger.debug("Editar Cliente {}",cliente);
        ModelAndView model = new ModelAndView("/cliente/add_customer");
        model.addObject("cliente", cliente);
        return model;
    }

    @RequestMapping(value = "/cliente/mostrar", method = RequestMethod.GET)
    public ModelAndView mostrar(HttpServletRequest request) {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = clienteService.buscarPorClave(idCliente);
        logger.debug("Mostrar cliente {}",cliente);
        ModelAndView model = new ModelAndView("/products/show_customer");
        model.addObject("cliente", cliente);
        return model;
    }

    @ModelAttribute("loggedinuser")
    public String UsuarioLogeado(){
        return super.UsuarioLogeado();
    }
}
