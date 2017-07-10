package com.maguzman.onbron.service.implementation;

import com.maguzman.onbron.beans.RolUsuario;
import com.maguzman.onbron.dao.RolUsuarioDAO;
import com.maguzman.onbron.service.RolUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Created by maguzman on 11/05/2017.
 */
@Service("rolUsuarioService")
@Transactional
public class RolUsuarioServiceImpl implements RolUsuarioService {
    @Autowired
    private RolUsuarioDAO dao;

    static final Logger logger =  LogManager.getLogger(RolUsuarioServiceImpl.class);

    public RolUsuario buscarPorClave(Integer idRolUsuario){
        logger.debug("idRolUsuario {}", idRolUsuario);
        return dao.buscarPorClave(idRolUsuario);
    }
    public RolUsuario buscarPorTipo(String tipo){
        return dao.buscarPorTipo(tipo);
    }
    public List<RolUsuario> buscarTodos(){
        return dao.buscarTodos();
    }

    @Override
    public void salvar(RolUsuario rolUsuario) {
        dao.salvar(rolUsuario);
    }

    @Override
    public void borrar(Integer idRolUsuario) {
        dao.borrar(idRolUsuario);
    }

    @Override
    public RolUsuario actualizar(RolUsuario rolUsuario) {
        return actualizar(rolUsuario);
    }
}
