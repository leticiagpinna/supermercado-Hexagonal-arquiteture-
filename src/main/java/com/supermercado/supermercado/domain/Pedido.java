package com.supermercado.supermercado.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe que representa um pedido feito por um cliente.
 */
@Data
@Document(collection = "pedidos")
public class Pedido {

    /**
     * ID único do pedido.
     */
    @Id
    private String id;

    /**
     * ID do cliente que fez o pedido.
     */
    private String clienteId;

    /**
     * Lista de IDs dos produtos do pedido.
     */
    private List<String> produtosIds;

    /**
     * Valor total do pedido.
     */
    private BigDecimal valorTotal;

    /**
     * Data e hora em que o pedido foi criado.
     */
    private LocalDateTime dataPedido;

    /**
     * Status atual do pedido.
     */
    private EnumStatusPedido status;
}