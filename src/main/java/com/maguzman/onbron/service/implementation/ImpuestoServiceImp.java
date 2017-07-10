package com.maguzman.onbron.service.implementation;

import com.maguzman.onbron.beans.Impuesto;
import com.maguzman.onbron.dao.ImpuestoDAO;
import com.maguzman.onbron.service.ImpuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
@Service("impuestoService")
@Transactional
public class ImpuestoServiceImp implements ImpuestoService {

    @Autowired
    private ImpuestoDAO impuestoDAO;

    @Override
    public Impuesto buscarPorClave(Integer idImpuesto) {
        return impuestoDAO.buscarPorClave(idImpuesto);
    }

    @Override
    public List<Impuesto> buscarTodos() {
        return (List<Impuesto>) impuestoDAO.buscarTodos();
    }

    @Override
    public void salvar(Impuesto impuesto) {
        impuestoDAO.salvar(impuesto);
    }

    @Override
    public void borrar(Integer idImpuesto) {
        impuestoDAO.borrar(idImpuesto);
    }

    @Override
    public Impuesto actualizar(Impuesto impuesto) {
        return impuestoDAO.actualizar(impuesto);
    }
}
