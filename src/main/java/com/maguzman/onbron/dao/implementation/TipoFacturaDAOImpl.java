package com.maguzman.onbron.dao.implementation;

import com.maguzman.onbron.beans.TipoFactura;
import com.maguzman.onbron.dao.TipoFacturaDAO;
import com.maguzman.onbron.dao.TipoPagoDAO;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Repository("tipoFacturaDAO")
public class TipoFacturaDAOImpl extends AbstractDAO<Integer, TipoFactura> implements TipoFacturaDAO {
    @Override
    public List<TipoFactura> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return criteria.list();
    }
}
