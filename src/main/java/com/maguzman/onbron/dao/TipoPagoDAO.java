package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.TipoPago;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
public interface TipoPagoDAO {
    TipoPago buscarPorClave(Integer idTipoPago);
    List<TipoPago> buscarTodos();
    void salvar(TipoPago tipoPago);
    void borrar(Integer idTipoPago);
    TipoPago actualizar(TipoPago categoria);
}
