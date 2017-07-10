package com.maguzman.onbron.service.implementation;

import com.maguzman.onbron.beans.TipoFactura;
import com.maguzman.onbron.dao.TipoFacturaDAO;
import com.maguzman.onbron.service.TipoFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Service("tipoFacturaService")
@Transactional
public class TipoFacturaServiceImpl implements TipoFacturaService {
    @Autowired
    private TipoFacturaDAO tipoFacturaDAO;

    @Override
    public TipoFactura buscarPorClave(Integer idTipoFactura) {
        return tipoFacturaDAO.buscarPorClave(idTipoFactura);
    }

    @Override
    public List<TipoFactura> buscarTodos() {
        return tipoFacturaDAO.buscarTodos();
    }

    @Override
    public void salvar(TipoFactura tipoFactura) {
        tipoFacturaDAO.salvar(tipoFactura);
    }

    @Override
    public void borrar(Integer idTipoFactura) {
        tipoFacturaDAO.borrar(idTipoFactura);
    }

    @Override
    public TipoFactura actualizar(TipoFactura tipoFactura) {
        return tipoFacturaDAO.actualizar(tipoFactura);
    }
}
