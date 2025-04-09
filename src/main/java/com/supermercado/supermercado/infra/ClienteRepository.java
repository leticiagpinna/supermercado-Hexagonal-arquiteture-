package com.supermercado.supermercado.infra;

import com.supermercado.supermercado.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositório de acesso aos dados dos clientes.
 */
@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByEmail(String email);
}