package com.fiap.spring.cloud.pedidos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Long id;
    private Long produtoId;
    private BigDecimal quantidade;
}
