package com.maguzman.onbron.dao.implementation;

import com.maguzman.onbron.beans.Inventario;
import com.maguzman.onbron.dao.InventarioDAO;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Repository("inventarioDAO")
public class InventarioDAOImpl extends AbstractDAO<Integer, Inventario> implements InventarioDAO {
    @Override
    public List<Inventario> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return criteria.list();
    }


}
