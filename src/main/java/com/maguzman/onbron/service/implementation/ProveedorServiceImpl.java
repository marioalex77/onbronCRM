package com.maguzman.onbron.service.implementation;

import com.maguzman.onbron.beans.Proveedor;
import com.maguzman.onbron.dao.ProveedorDAO;
import com.maguzman.onbron.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
@Service("proveedorService")
@Transactional
public class ProveedorServiceImpl implements ProveedorService {
    @Autowired
    private ProveedorDAO proveedorDAO;


    public Proveedor buscarPorClave(Integer idProveedor){
        return proveedorDAO.buscarPorClave(idProveedor);
    }

    public List<Proveedor> buscarTodos(){
        return proveedorDAO.buscarTodos();
    }
    public void salvar(Proveedor proveedor){
        proveedorDAO.salvar(proveedor);
    }

    public void borrar(Integer idProveedor){
        proveedorDAO.borrar(idProveedor);
    }

    public Proveedor actualizar(Proveedor proveedor){
        return proveedorDAO.actualizar(proveedor);
    }
}
