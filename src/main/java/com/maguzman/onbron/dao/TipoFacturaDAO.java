package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.TipoFactura;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
public interface TipoFacturaDAO {
    TipoFactura buscarPorClave(Integer idTipoFactura);
    List<TipoFactura> buscarTodos();
    void salvar(TipoFactura tipoFactura);
    void borrar(Integer idTipoFactura);
    TipoFactura actualizar(TipoFactura tipoFactura);
}
