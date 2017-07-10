package com.maguzman.onbron.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.maguzman.onbron.beans.RolUsuario;
import com.maguzman.onbron.service.RolUsuarioService;


/**
 * Created by maguzman on 12/05/2017.
 */
@Component
public class RoleToUserProfileConverter implements Converter <Object, RolUsuario> {
    static final Logger logger =  LogManager.getLogger(RoleToUserProfileConverter.class);

    @Autowired
    RolUsuarioService rolUsuarioService;

    public RolUsuario convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        logger.debug("ID : {}",id);
        RolUsuario rolUsuario= rolUsuarioService.buscarPorClave(id);
        logger.debug("Rol Usuario : {}",rolUsuario);
        return rolUsuario;
    }
}
