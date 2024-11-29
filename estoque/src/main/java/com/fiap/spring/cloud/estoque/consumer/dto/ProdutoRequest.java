package com.fiap.spring.cloud.estoque.consumer.dto;

import java.math.BigDecimal;

public record ProdutoRequest(Long id, BigDecimal quantity) {
}
