package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.FacturaItem;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
public interface FacturaItemDAO {
    FacturaItem buscarPorClave(Integer idFacturaItem);
    List<FacturaItem> buscarTodos();
    void salvar(FacturaItem facturaItem);
    void borrar(Integer idFacturaItem);
    FacturaItem actualizar(FacturaItem facturaItem);
}
