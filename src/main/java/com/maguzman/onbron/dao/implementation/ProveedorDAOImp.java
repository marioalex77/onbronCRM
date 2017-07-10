package com.maguzman.onbron.dao.implementation;

import com.maguzman.onbron.beans.Proveedor;
import com.maguzman.onbron.dao.ProveedorDAO;
import com.maguzman.onbron.dao.implementation.AbstractDAO;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
@Repository("proveedorDAO")
public class ProveedorDAOImp extends AbstractDAO<Integer, Proveedor> implements ProveedorDAO {
    @Override
    public List<Proveedor> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return (List<Proveedor>) criteria.list();
    }
}
