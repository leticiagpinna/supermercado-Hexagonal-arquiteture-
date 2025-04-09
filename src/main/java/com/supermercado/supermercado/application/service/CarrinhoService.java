package com.supermercado.supermercado.application.service;


import com.supermercado.supermercado.domain.Carrinho;
import com.supermercado.supermercado.domain.Produto;
import com.supermercado.supermercado.infra.repository.CarrinhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Serviço responsável pelas operações relacionadas ao carrinho de compras.
 */
@Service
@RequiredArgsConstructor
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

    /**
     * Adiciona um produto ao carrinho do cliente.
     */
    public Carrinho adicionarProduto(String clienteId, Produto produto) {
        Carrinho carrinho = carrinhoRepository.findByClienteId(clienteId).orElseGet(() -> {
            Carrinho novoCarrinho = new Carrinho();
            novoCarrinho.setClienteId(clienteId);
            novoCarrinho.setProdutos(new ArrayList<>());
            novoCarrinho.setValorTotal(BigDecimal.ZERO);
            return novoCarrinho;
        });

        carrinho.getProdutos().add(produto);
        atualizarValorTotal(carrinho);
        return carrinhoRepository.save(carrinho);
    }

    /**
     * Remove um produto do carrinho.
     */
    public Carrinho removerProduto(String clienteId, String produtoId) {
        Carrinho carrinho = carrinhoRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        carrinho.getProdutos().removeIf(p -> p.getId().equals(produtoId));
        atualizarValorTotal(carrinho);
        return carrinhoRepository.save(carrinho);
    }

    /**
     * Retorna o carrinho atual do cliente.
     */
    public Carrinho obterCarrinho(String clienteId) {
        return carrinhoRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
    }

    /**
     * Atualiza o valor total com base nos produtos.
     */
    private void atualizarValorTotal(Carrinho carrinho) {
        BigDecimal total = carrinho.getProdutos().stream()
                .map(Produto::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        carrinho.setValorTotal(total);
    }
}

