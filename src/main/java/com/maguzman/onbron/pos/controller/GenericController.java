package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by maguzman on 18/05/2017.
 */

public abstract class GenericController {
    @Autowired
    private UsuarioService usuarioService;

    public String UsuarioLogeado(){
        return usuarioService.buscarPorCorreo(getPrincipal()).getNombres();
    }

    protected String getPrincipal(){
        String nombreUsuario = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            nombreUsuario = ((UserDetails) principal).getUsername();
        }
        else {
            nombreUsuario = principal.toString();
        }
        return nombreUsuario;
    }
}
