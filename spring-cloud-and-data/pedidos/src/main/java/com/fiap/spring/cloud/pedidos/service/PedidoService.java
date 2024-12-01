package com.fiap.spring.cloud.pedidos.service;

import com.fiap.spring.cloud.pedidos.client.EstoqueClient;
import com.fiap.spring.cloud.pedidos.client.request.RemoverEstoqueRequest;
import com.fiap.spring.cloud.pedidos.domain.Pedido;
import com.fiap.spring.cloud.pedidos.repository.PedidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PedidoService {
    private final PedidoRepository repository;
    private final EstoqueClient estoqueClient;

    public PedidoService(PedidoRepository repository, EstoqueClient estoqueClient) {
        this.repository = repository;
        this.estoqueClient = estoqueClient;
    }

    public List<Pedido> findAll() {
        return this.repository.findAll();
    }

    public void save(final Pedido pedido) {
        try {
            pedido.getItens()
                    .forEach(item -> estoqueClient.removerEstoque(
                            new RemoverEstoqueRequest(item.getProdutoId(), item.getQuantidade())
                    ));

            repository.save(pedido);
        } catch (Exception e) {
            log.info("deu erro: {}", e.getMessage(), e);
            throw new UnsupportedOperationException("Fora de estoque");
        }
    }
}
