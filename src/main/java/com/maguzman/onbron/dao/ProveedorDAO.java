package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.Proveedor;

import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
public interface ProveedorDAO {
    Proveedor buscarPorClave(Integer idProveedor);
    List<Proveedor> buscarTodos();
    void salvar(Proveedor proveedor);
    void borrar(Integer idProveedor);
    Proveedor actualizar(Proveedor proveedor);
}
