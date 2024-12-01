package com.fiap.spring.cloud.pedidos.gateway.request;

import java.math.BigDecimal;

public record RemoverEstoqueRequest(Long id, BigDecimal quantidade) {
}
