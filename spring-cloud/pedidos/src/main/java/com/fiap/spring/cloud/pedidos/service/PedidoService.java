package com.fiap.spring.cloud.pedidos.service;

import com.fiap.spring.cloud.pedidos.client.EstoqueClient;
import com.fiap.spring.cloud.pedidos.client.request.RemoverEstoqueRequest;
import com.fiap.spring.cloud.pedidos.domain.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PedidoService {
    private List<Pedido> fakeDb = new ArrayList<>();

    private final EstoqueClient estoqueClient;

    public PedidoService(EstoqueClient estoqueClient) {
        this.estoqueClient = estoqueClient;
    }

    public List<Pedido> findAll() {
        return this.fakeDb;
    }

    public void save(final Pedido pedido) {
        try {
            pedido.getItens()
                    .forEach(item -> estoqueClient.removerEstoque(
                            new RemoverEstoqueRequest(item.getProdutoId(), item.getQuantidade())
                    ));

            fakeDb.add(pedido);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Fora de estoque");
        }
    }
}
