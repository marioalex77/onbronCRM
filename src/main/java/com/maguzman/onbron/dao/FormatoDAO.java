package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.Formato;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
public interface FormatoDAO {
    Formato buscarPorClave(Integer idFormato);
    List<Formato>  buscarTodos();
    void salvar(Formato formato);
    void borrar(Integer idFormato);
    Formato actualizar(Formato formato);
}
