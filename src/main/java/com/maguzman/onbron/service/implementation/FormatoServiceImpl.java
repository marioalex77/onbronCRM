package com.maguzman.onbron.service.implementation;

import com.maguzman.onbron.beans.Formato;
import com.maguzman.onbron.dao.FormatoDAO;
import com.maguzman.onbron.service.FormatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Service("formatoService")
@Transactional
public class FormatoServiceImpl implements FormatoService{
    @Autowired
    private FormatoDAO formatoDAO;

    @Override
    public Formato buscarPorClave(Integer idFormato) {
        return formatoDAO.buscarPorClave(idFormato);
    }

    @Override
    public List<Formato> buscarTodos() {
        return formatoDAO.buscarTodos();
    }

    @Override
    public void salvar(Formato formato) {
        formatoDAO.salvar(formato);
    }

    @Override
    public void borrar(Integer idFormato) {
        formatoDAO.borrar(idFormato);
    }

    @Override
    public Formato actualizar(Formato formato) {
        return formatoDAO.actualizar(formato);
    }
}
