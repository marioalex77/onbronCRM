package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.Factura;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
public interface FacturaDAO {
    Factura buscarPorClave(Integer idFactura);
    List<Factura> buscarTodos();
    void salvar(Factura factura);
    void borrar(Integer idFormato);
    Factura actualizar(Factura factura);
}
