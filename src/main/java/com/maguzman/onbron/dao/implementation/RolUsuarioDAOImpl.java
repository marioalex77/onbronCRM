package com.maguzman.onbron.dao.implementation;

import com.maguzman.onbron.beans.RolUsuario;
import com.maguzman.onbron.dao.RolUsuarioDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Created by maguzman on 11/05/2017.
 */
@Repository("rolUsuarioDAO")
public class RolUsuarioDAOImpl extends AbstractDAO<Integer, RolUsuario> implements RolUsuarioDAO {

    static final Logger logger =  LogManager.getLogger(RolUsuarioDAOImpl.class);

    public RolUsuario buscarPorTipo(String tipo){
        Criteria crit = createCriterioEntidad();
        crit.add(Restrictions.eq("tipo", tipo));
        return (RolUsuario) crit.uniqueResult();
    }

    public List<RolUsuario> buscarTodos(){
        Criteria crit = createCriterioEntidad();
        crit.addOrder(Order.asc("tipo"));
        return (List<RolUsuario>) crit.list();
    }
}
