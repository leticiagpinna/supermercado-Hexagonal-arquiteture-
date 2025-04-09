package com.supermercado.supermercado.infra.repository;

import com.supermercado.supermercado.domain.Carrinho;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Interface de acesso ao banco de dados para Carrinho.
 */
public interface CarrinhoRepository extends MongoRepository<Carrinho, String> {
    Optional<Carrinho> findByClienteId(String clienteId);
}