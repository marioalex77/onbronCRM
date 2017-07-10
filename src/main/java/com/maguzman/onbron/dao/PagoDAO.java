package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.Pago;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
public interface PagoDAO {
    Pago buscarPorClave(Integer idPago);
    List<Pago> buscarTodos();
    void salvar(Pago pago);
    void borrar(Integer idPago);
    Pago actualizar(Pago pago);
}
