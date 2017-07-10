package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.Producto;

import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
public interface ProductoDAO {
    Producto buscarPorClave(Integer idProducto);
    List<Producto> buscarTodos();
    void salvar(Producto producto);
    void borrar(Integer idProducto);
    Producto actualizar(Producto producto);
}
