package com.maguzman.onbron.dao.implementation;

import com.maguzman.onbron.beans.Impuesto;
import com.maguzman.onbron.dao.ImpuestoDAO;
import com.maguzman.onbron.dao.implementation.AbstractDAO;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
@Repository("impuestoDAO")
public class ImpuestoDAOImpl extends AbstractDAO<Integer,Impuesto> implements ImpuestoDAO {
    @Override
    public List<Impuesto> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return (List<Impuesto>) criteria.list();
    }
}
