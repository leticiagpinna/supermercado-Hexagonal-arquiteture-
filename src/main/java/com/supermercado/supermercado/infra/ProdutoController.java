package com.supermercado.supermercado.infra;


import com.supermercado.supermercado.application.ProdutoService;
import com.supermercado.supermercado.domain.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável pelos endpoints relacionados a produtos.
 */
@RestController
@RequestMapping("/api/mercado")
public class ProdutoController {

    private final ProdutoService produtoService;

    
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.salvarProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable String id) {
        return produtoService.buscarProdutoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable String id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}

