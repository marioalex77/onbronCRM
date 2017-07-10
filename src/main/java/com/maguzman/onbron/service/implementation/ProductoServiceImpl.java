package com.maguzman.onbron.service.implementation;

import com.maguzman.onbron.beans.Producto;
import com.maguzman.onbron.dao.ProductoDAO;
import com.maguzman.onbron.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
@Service("productoService")
@Transactional
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoDAO productoDAO;

    @Override
    public Producto buscarPorClave(Integer idProducto) {
        return productoDAO.buscarPorClave(idProducto);
    }

    @Override
    public List<Producto> buscarTodos() {
        return productoDAO.buscarTodos();
    }

    @Override
    public void salvar(Producto producto) {
        productoDAO.salvar(producto);
    }

    @Override
    public void borrar(Integer idProducto) {
        productoDAO.borrar(idProducto);
    }

    @Override
    public Producto actualizar(Producto producto) {
        return productoDAO.actualizar(producto);
    }
}
