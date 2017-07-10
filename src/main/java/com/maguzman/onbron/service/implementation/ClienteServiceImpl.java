package com.maguzman.onbron.service.implementation;

import com.maguzman.onbron.beans.Cliente;
import com.maguzman.onbron.dao.ClienteDAO;
import com.maguzman.onbron.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maguzman on 24/05/2017.
 */
@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public Cliente buscarPorClave(Integer idCliente) {
        return clienteDAO.buscarPorClave(idCliente);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteDAO.buscarTodos();
    }

    @Override
    public void salvar(Cliente cliente) {
        clienteDAO.salvar(cliente);
    }

    @Override
    public void borrar(Integer idCliente) {
        clienteDAO.borrar(idCliente);
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        return clienteDAO.actualizar(cliente);
    }
}
