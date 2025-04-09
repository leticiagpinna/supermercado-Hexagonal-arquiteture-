package com.supermercado.supermercado.infra;

import com.supermercado.supermercado.domain.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório de acesso aos pedidos.
 */
@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String> {
}