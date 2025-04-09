package com.supermercado.supermercado.application;

import com.supermercado.supermercado.domain.EnumStatusPedido;
import com.supermercado.supermercado.domain.Pedido;
import com.supermercado.supermercado.domain.Produto;
import com.supermercado.supermercado.infra.PedidoRepository;
import com.supermercado.supermercado.infra.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Serviço responsável pela lógica de negócios dos pedidos.
 */
@Service
public class PedidoService {
/**
 * Preço do produto.
 */
   
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;


    public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    /**
     * Cria um novo pedido com base nos produtos e cliente.
     * @param pedido Pedido a ser criado.
     * @return Pedido criado com valor total e data preenchidos.
     */
    public Pedido criarPedido(Pedido pedido) {
        List<Produto> produtos = produtoRepository.findAllById(pedido.getProdutosIds());

        BigDecimal valorTotal = produtos.stream()
                .map(Produto::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        pedido.setValorTotal(valorTotal);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(EnumStatusPedido.EM_ANDAMENTO);

        return pedidoRepository.save(pedido);
    }

    /**
     * Lista todos os pedidos cadastrados.
     * @return Lista de pedidos.
     */
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
