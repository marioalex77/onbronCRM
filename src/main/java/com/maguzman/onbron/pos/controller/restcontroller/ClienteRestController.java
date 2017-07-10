package com.maguzman.onbron.pos.controller.restcontroller;

import com.maguzman.onbron.beans.Cliente;
import com.maguzman.onbron.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by maguzman on 02/06/2017.
 */
@RestController
public class ClienteRestController {

    private static final Logger logger = LogManager.getLogger(ClienteRestController.class);

    @Autowired
    ClienteService clienteService;

    @RequestMapping(value="/cliente/", method = RequestMethod.POST)
    public ResponseEntity<Void> crearCliente(@RequestBody Cliente cliente, UriComponentsBuilder ucBuilder){
        logger.info("Creando cliente" +  cliente.getNombres());
        if(clienteService.buscarPorClave(cliente.getIdCliente())==null){
            logger.error("Ya existe usuario con nombre" + cliente.getNombres());
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        clienteService.salvar(cliente);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/cliente/{id}").buildAndExpand(cliente.getIdCliente()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
