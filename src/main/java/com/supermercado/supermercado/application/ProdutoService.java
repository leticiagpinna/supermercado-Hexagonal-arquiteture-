package com.supermercado.supermercado.application;
import com.supermercado.supermercado.domain.Produto;
import com.supermercado.supermercado.infra.ProdutoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio relacionada a produtos.
 */
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    /**
     * Salva um novo produto no banco de dados.
     *
     * @param produto Produto a ser salvo.
     * @return Produto salvo.
     */
    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    /**
     * Retorna todos os produtos cadastrados.
     *
     * @return Lista de produtos.
     */
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    /**
     * Retorna um produto pelo ID.
     *
     * @param id Identificador do produto.
     * @return Produto encontrado ou vazio.
     */
    public Optional<Produto> buscarProdutoPorId(String id) {
        return produtoRepository.findById(id);
    }

    /**
     * Remove um produto pelo ID.
     *
     * @param id Identificador do produto a ser removido.
     */
    public void deletarProduto(String id) {
        produtoRepository.deleteById(id);
    }
}