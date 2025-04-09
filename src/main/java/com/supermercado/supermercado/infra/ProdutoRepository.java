package com.supermercado.supermercado.infra;


import com.supermercado.supermercado.domain.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório responsável por operações de acesso a dados do produto.
 */
@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
}