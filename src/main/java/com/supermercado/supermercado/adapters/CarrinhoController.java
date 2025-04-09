package com.supermercado.supermercado.adapters;

import com.supermercado.supermercado.application.service.CarrinhoService;
import com.supermercado.supermercado.domain.Carrinho;
import com.supermercado.supermercado.domain.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Controller REST responsável pelas operações do carrinho de compras.
 */
@RestController
@RequestMapping("/api/carrinho")
@RequiredArgsConstructor
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    /**
     * Adiciona um produto ao carrinho do cliente.
     */
    @PostMapping("/{clienteId}/adicionar")
    public Carrinho adicionarProduto(@PathVariable String clienteId, @RequestBody Produto produto) {
        return carrinhoService.adicionarProduto(clienteId, produto);
    }

    /**
     * Remove um produto do carrinho.
     */
    @DeleteMapping("/{clienteId}/remover/{produtoId}")
    public Carrinho removerProduto(@PathVariable String clienteId, @PathVariable String produtoId) {
        return carrinhoService.removerProduto(clienteId, produtoId);
    }

    /**
     * Obtém o carrinho atual do cliente.
     */
    @GetMapping("/{clienteId}")
    public Carrinho obterCarrinho(@PathVariable String clienteId) {
        return carrinhoService.obterCarrinho(clienteId);
    }
}
