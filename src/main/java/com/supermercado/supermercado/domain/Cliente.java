package com.supermercado.supermercado.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe que representa um cliente do supermercado.
 */
@Data
@Document(collection = "clientes")
public class Cliente {

    /**
     * Identificador único do cliente.
     */
    @Id
    private String id;

    /**
     * Nome completo do cliente.
     */
    private String nome;

    /**
     * Email para contato.
     */
    private String email;

    /**
     * CPF do cliente.
     */
    private String cpf;

    /**
     * Senha (será criptografada).
     */
    private String senha;
}
