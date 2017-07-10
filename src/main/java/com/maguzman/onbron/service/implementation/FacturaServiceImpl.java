package com.maguzman.onbron.service.implementation;

import com.maguzman.onbron.beans.Factura;
import com.maguzman.onbron.dao.FacturaDAO;
import com.maguzman.onbron.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Service("facturaService")
@Transactional
public class FacturaServiceImpl implements FacturaService{
    @Autowired
    FacturaDAO facturaDAO;

    @Override
    public Factura buscarPorClave(Integer idFactura) {
        return facturaDAO.buscarPorClave(idFactura);
    }

    @Override
    public List<Factura> buscarTodos() {
        return facturaDAO.buscarTodos();
    }

    @Override
    public void salvar(Factura factura) {
        facturaDAO.salvar(factura);
    }

    @Override
    public void borrar(Integer idFactura) {
        facturaDAO.borrar(idFactura);
    }

    @Override
    public Factura actualizar(Factura factura) {
        return facturaDAO.actualizar(factura);
    }
}
