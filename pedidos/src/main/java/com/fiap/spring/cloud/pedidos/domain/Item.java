package com.fiap.spring.cloud.pedidos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Item {
    private Long id;
    private Long produtoId;
    private BigDecimal quantidade;
}
