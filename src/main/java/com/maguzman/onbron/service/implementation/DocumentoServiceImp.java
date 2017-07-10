package com.maguzman.onbron.service.implementation;

import com.maguzman.onbron.beans.Documento;
import com.maguzman.onbron.dao.DocumentoDAO;
import com.maguzman.onbron.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by maguzman on 18/5/2017.
 */
@Service("documentoService")
@Transactional
public class DocumentoServiceImp implements DocumentoService {
    @Autowired
    private DocumentoDAO documentoDAO;

    @Override
    public Documento buscarPorClave(Integer idDocumento) {
        return documentoDAO.buscarPorClave(idDocumento);
    }

    @Override
    public List<Documento> buscarTodos() {
        return documentoDAO.buscarTodos();
    }

    @Override
    public void salvar(Documento documento) {
        documentoDAO.salvar(documento);
    }

    @Override
    public void borrar(Integer idDocumento) {
        documentoDAO.borrar(idDocumento);
    }

    @Override
    public Documento actualizar(Documento documento) {
        return documentoDAO.actualizar(documento);
    }
}
