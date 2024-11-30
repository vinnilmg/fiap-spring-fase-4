package com.fiap.spring.cloud.pedidos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    private UUID id;
    private UUID clienteId;
    private List<Item> itens;
}
