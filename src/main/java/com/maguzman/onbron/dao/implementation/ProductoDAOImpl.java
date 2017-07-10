package com.maguzman.onbron.dao.implementation;

import com.maguzman.onbron.beans.Producto;
import com.maguzman.onbron.dao.ProductoDAO;
import com.maguzman.onbron.dao.implementation.AbstractDAO;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
@Repository("productoDAO")
public class ProductoDAOImpl extends AbstractDAO<Integer,Producto> implements ProductoDAO {
    @Override
    public List<Producto> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return (List<Producto>) criteria.list();
    }
}
