package com.maguzman.onbron.dao.implementation;

import com.maguzman.onbron.beans.FacturaItem;
import com.maguzman.onbron.dao.FacturaItemDAO;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Repository("facturaItemDAO")
public class FacturaItemDAOImpl extends AbstractDAO<Integer, FacturaItem> implements FacturaItemDAO {
    @Override
    public List<FacturaItem> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return criteria.list();
    }
}
