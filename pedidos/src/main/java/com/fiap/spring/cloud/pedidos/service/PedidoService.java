package com.fiap.spring.cloud.pedidos.service;

import com.fiap.spring.cloud.pedidos.domain.Pedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    private List<Pedido> fakeDb = new ArrayList<>();

    public List<Pedido> findAll() {
        return this.fakeDb;
    }
}
