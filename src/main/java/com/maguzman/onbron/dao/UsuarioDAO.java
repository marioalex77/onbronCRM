package com.maguzman.onbron.dao;

import java.util.List;

import com.maguzman.onbron.beans.Usuario;

/**
 * Created by maguzman on 11/05/2017.
 */

public interface UsuarioDAO {
    Usuario buscarPorClave(Integer idUsuario);
    Usuario buscarPorCorreo(String correo);
    List<Usuario> buscarTodos();
    void salvar(Usuario usuario);
    void borrar(Integer usuario);
    void borrarPorCorreo(String correo);
    Usuario actualizar(Usuario usuario);
}
