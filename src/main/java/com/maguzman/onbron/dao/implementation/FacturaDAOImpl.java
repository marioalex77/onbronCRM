package com.maguzman.onbron.dao.implementation;

import com.maguzman.onbron.beans.Factura;
import com.maguzman.onbron.dao.FacturaDAO;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Repository("facturaDAO")
public class FacturaDAOImpl extends AbstractDAO<Integer, Factura> implements FacturaDAO {
    @Override
    public List<Factura> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return criteria.list();
    }
}
