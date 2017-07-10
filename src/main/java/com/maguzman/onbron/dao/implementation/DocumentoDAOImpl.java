package com.maguzman.onbron.dao.implementation;

import com.maguzman.onbron.beans.Documento;
import com.maguzman.onbron.dao.DocumentoDAO;
import com.maguzman.onbron.dao.implementation.AbstractDAO;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
@Repository("documentoDAO")
public class DocumentoDAOImpl extends AbstractDAO<Integer,Documento> implements DocumentoDAO {
    @Override
    public List<Documento> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return (List<Documento>) criteria.list();
    }
}
