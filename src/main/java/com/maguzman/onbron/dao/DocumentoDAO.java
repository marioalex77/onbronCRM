package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.Documento;

import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
public interface DocumentoDAO {
    Documento buscarPorClave(Integer idDocumento);
    List<Documento> buscarTodos();
    void salvar(Documento documento);
    void borrar(Integer idDocumento);
    Documento actualizar(Documento documento);
}
