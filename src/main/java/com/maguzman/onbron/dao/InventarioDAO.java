package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.Inventario;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
public interface InventarioDAO {
    Inventario buscarPorClave(Integer idInventario);
    List<Inventario> buscarTodos();
    void salvar(Inventario inventario);
    void borrar(Integer idInventario);
    Inventario actualizar(Inventario inventario);
}
