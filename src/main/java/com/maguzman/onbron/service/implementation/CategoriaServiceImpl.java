package com.maguzman.onbron.service.implementation;

/**
 * Created by maguzman on 27/04/2017.
 */

import java.util.List;

import com.maguzman.onbron.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maguzman.onbron.dao.CategoriaDAO;
import com.maguzman.onbron.beans.Categoria;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service("categoriaService")
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDAO categoriaDAO;

    public Categoria buscarPorClave(Integer idCategoria){
        return categoriaDAO.buscarPorClave(idCategoria);
    }

    public List<Categoria> buscarTodos(){
        return categoriaDAO.buscarTodos();
    }
    public void salvar(Categoria categoria){
        categoriaDAO.salvar(categoria);
    }

    public void borrar(Integer idCategoria){
        categoriaDAO.borrar(idCategoria);
    }

    public Categoria actualizar(Categoria categoria){
        return categoriaDAO.actualizar(categoria);
    }

}
