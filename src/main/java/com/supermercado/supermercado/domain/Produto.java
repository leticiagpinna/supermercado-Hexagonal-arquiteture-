package com.supermercado.supermercado.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Classe que representa um produto no domínio do supermercado.
 */
@Data
@Document(collection = "produtos")
public class Produto {

    /**
     * Identificador único do produto.
     */
    @Id
    private String id;

    /**
     * Nome do produto.
     */
    private String nome;

    /**
     * Descrição do produto.
     */
    private String descricao;

    /**
     * Preço do produto. Usar BigDecimal garante precisão nos cálculos.
     */
    private BigDecimal preco;

    /**
     * Quantidade disponível em estoque.
     */
    private int quantidadeEstoque;
}
