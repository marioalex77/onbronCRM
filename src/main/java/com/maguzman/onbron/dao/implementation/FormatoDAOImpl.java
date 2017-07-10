package com.maguzman.onbron.dao.implementation;

import com.maguzman.onbron.beans.Formato;
import com.maguzman.onbron.dao.FormatoDAO;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Repository("formatoDAO")
public class FormatoDAOImpl extends AbstractDAO<Integer, Formato> implements FormatoDAO {
    public List<Formato> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return criteria.list();
    }
}
