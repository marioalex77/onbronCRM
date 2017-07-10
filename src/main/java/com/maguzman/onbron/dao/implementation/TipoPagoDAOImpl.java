package com.maguzman.onbron.dao.implementation;

import com.maguzman.onbron.beans.TipoPago;
import com.maguzman.onbron.dao.TipoPagoDAO;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Repository("tipoPagoDAO")
public class TipoPagoDAOImpl extends AbstractDAO<Integer, TipoPago> implements TipoPagoDAO {

    public List<TipoPago> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return criteria.list();
    }
}
