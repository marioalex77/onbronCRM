package com.maguzman.onbron.service.implementation;

import com.maguzman.onbron.beans.FacturaItem;
import com.maguzman.onbron.dao.FacturaItemDAO;
import com.maguzman.onbron.service.FacturaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Service("facturaItemService")
@Transactional
public class FacturaItemServiceImpl implements FacturaItemService{
    @Autowired
    FacturaItemDAO facturaItemDAO;
    @Override
    public FacturaItem buscarPorClave(Integer idFacturaItem) {
        return facturaItemDAO.buscarPorClave(idFacturaItem);
    }

    @Override
    public List<FacturaItem> buscarTodos() {
        return facturaItemDAO.buscarTodos();
    }

    @Override
    public void salvar(FacturaItem facturaItem) {
        facturaItemDAO.salvar(facturaItem);
    }

    @Override
    public void borrar(Integer idFacturaItem) {
        facturaItemDAO.borrar(idFacturaItem);
    }

    @Override
    public FacturaItem actualizar(FacturaItem facturaItem) {
        return facturaItemDAO.actualizar(facturaItem);
    }
}
