package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.Impuesto;

import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
public interface ImpuestoDAO {
    Impuesto buscarPorClave(Integer idImpuesto);
    List<Impuesto> buscarTodos();
    void salvar(Impuesto impuesto);
    void borrar(Integer idImpuesto);
    Impuesto actualizar(Impuesto impuesto);
}
