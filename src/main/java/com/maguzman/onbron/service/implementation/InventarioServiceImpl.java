package com.maguzman.onbron.service.implementation;

import com.maguzman.onbron.beans.Inventario;
import com.maguzman.onbron.dao.InventarioDAO;
import com.maguzman.onbron.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Service("inventarioService")
@Transactional
public class InventarioServiceImpl implements InventarioService {
    @Autowired
    InventarioDAO inventarioDAO;
    @Override
    public Inventario buscarPorClave(Integer idInventario) {
        return inventarioDAO.buscarPorClave(idInventario);
    }

    @Override
    public List<Inventario> buscarTodos() {
        return inventarioDAO.buscarTodos();
    }

    @Override
    public void salvar(Inventario inventario) {
        inventarioDAO.salvar(inventario);
    }

    @Override
    public void borrar(Integer idInventario) {
        inventarioDAO.borrar(idInventario);
    }

    @Override
    public Inventario actualizar(Inventario inventario) {
        return inventarioDAO.actualizar(inventario);
    }
}
