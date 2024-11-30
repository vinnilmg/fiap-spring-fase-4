package com.fiap.spring.cloud.pedidos.client.request;

import java.math.BigDecimal;

public record RemoverEstoqueRequest(Long id, BigDecimal quantidade) {
}
