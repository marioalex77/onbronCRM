package com.maguzman.onbron.dao.implementation;

import com.maguzman.onbron.beans.Cliente;
import com.maguzman.onbron.dao.ClienteDAO;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Repository("clienteDAO")
public class ClienteDAOImpl extends AbstractDAO<Integer, Cliente> implements ClienteDAO {
    public List<Cliente> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return criteria.list();
    }
}
