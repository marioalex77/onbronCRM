package com.maguzman.onbron.dao.implementation;
/**
 * Created by maguzman on 27/04/2017.
 */
import java.util.List;

import com.maguzman.onbron.dao.CategoriaDAO;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.maguzman.onbron.beans.Categoria;

@Repository("categoriaDAO")
public class CategoriaDAOImpl extends AbstractDAO<Integer, Categoria> implements CategoriaDAO {
    @Override
    public List<Categoria> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return (List<Categoria>) criteria.list();
    }
}
