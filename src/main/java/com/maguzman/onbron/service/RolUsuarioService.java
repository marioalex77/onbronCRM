package com.maguzman.onbron.service;

import com.maguzman.onbron.beans.RolUsuario;

import java.util.List;

/**
 * Created by maguzman on 11/05/2017.
 */
public interface RolUsuarioService extends AbstractService<Integer,RolUsuario> {
    RolUsuario buscarPorTipo(String tipo);
}
