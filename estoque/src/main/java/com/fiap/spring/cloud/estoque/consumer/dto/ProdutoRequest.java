package com.fiap.spring.cloud.estoque.consumer.dto;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class ProdutoRequest {
    private Long id;
    private BigDecimal quantidade;
}
