package com.supermercado.supermercado.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

/**
 * Classe que representa um carrinho de compras associado a um cliente.
 */
@Data
@Document(collection = "carrinhos")
public class Carrinho {

    @Id
    private String id;

    private String clienteId;

    private List<Produto> produtos;

    private BigDecimal valorTotal;
}