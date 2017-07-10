package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.Cliente;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
public interface ClienteDAO {
    Cliente buscarPorClave(Integer idCliente);
    List<Cliente> buscarTodos();
    void salvar(Cliente cliente);
    void borrar(Integer idCliente);
    Cliente actualizar(Cliente cliente);
}
