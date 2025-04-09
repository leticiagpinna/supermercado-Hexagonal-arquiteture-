package com.supermercado.supermercado.application;

import com.supermercado.supermercado.domain.Cliente;
import com.supermercado.supermercado.infra.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio dos clientes.
 */
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Cadastra um novo cliente.
     * @param cliente Cliente a ser salvo.
     * @return Cliente salvo.
     */
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Lista todos os clientes.
     * @return Lista de clientes.
     */
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    /**
     * Busca cliente pelo ID.
     * @param id ID do cliente.
     * @return Cliente, se encontrado.
     */
    public Optional<Cliente> buscarPorId(String id) {
        return clienteRepository.findById(id);
    }

    /**
     * Deleta cliente por ID.
     * @param id ID do cliente.
     */
    public void deletarCliente(String id) {
        clienteRepository.deleteById(id);
    }
}