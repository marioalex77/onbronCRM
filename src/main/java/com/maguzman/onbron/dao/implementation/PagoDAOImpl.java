package com.maguzman.onbron.dao.implementation;

import com.maguzman.onbron.beans.Pago;
import com.maguzman.onbron.dao.PagoDAO;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Repository("pagoDAO")
public class PagoDAOImpl extends AbstractDAO<Integer, Pago> implements PagoDAO {
    @Override
    public List<Pago> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return criteria.list();
    }
}
