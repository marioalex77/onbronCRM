package com.maguzman.onbron.service.implementation;

import com.maguzman.onbron.beans.Pago;
import com.maguzman.onbron.dao.PagoDAO;
import com.maguzman.onbron.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Service("pagoService")
@Transactional
public class PagoServiceImpl implements PagoService{
    @Autowired
    private PagoDAO pagoDAO;

    @Override
    public Pago buscarPorClave(Integer idPago) {
        return pagoDAO.buscarPorClave(idPago);
    }

    @Override
    public List<Pago> buscarTodos() {
        return pagoDAO.buscarTodos();
    }

    @Override
    public void salvar(Pago pago) {
        pagoDAO.salvar(pago);
    }

    @Override
    public void borrar(Integer idPago) {
        pagoDAO.borrar(idPago);
    }

    @Override
    public Pago actualizar(Pago pago) {
        return pagoDAO.actualizar(pago);
    }
}
