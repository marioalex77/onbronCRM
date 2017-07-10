package com.maguzman.onbron.service.implementation;

import com.maguzman.onbron.beans.TipoPago;
import com.maguzman.onbron.dao.TipoPagoDAO;
import com.maguzman.onbron.service.TipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Service("tipoPagoService")
@Transactional
public class TipoPagoServiceImpl implements TipoPagoService {
    @Autowired
    private TipoPagoDAO tipoPagoDAO;

    @Override
    public TipoPago buscarPorClave(Integer idTipoPago) {
        return tipoPagoDAO.buscarPorClave(idTipoPago);
    }

    @Override
    public List<TipoPago> buscarTodos() {
        return tipoPagoDAO.buscarTodos();
    }

    @Override
    public void salvar(TipoPago tipoPago) {
        tipoPagoDAO.salvar(tipoPago);
    }

    @Override
    public void borrar(Integer idTipoPago) {
        tipoPagoDAO.borrar(idTipoPago);
    }

    @Override
    public TipoPago actualizar(TipoPago tipoPago) {
        return tipoPagoDAO.actualizar(tipoPago);
    }
}
