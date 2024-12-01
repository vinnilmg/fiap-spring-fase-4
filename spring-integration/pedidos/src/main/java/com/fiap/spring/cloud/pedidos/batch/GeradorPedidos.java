package com.fiap.spring.cloud.pedidos.batch;

import com.fiap.spring.cloud.pedidos.domain.Item;
import com.fiap.spring.cloud.pedidos.domain.Pedido;
import com.fiap.spring.cloud.pedidos.service.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class GeradorPedidos {
    private final PedidoService service;

    public GeradorPedidos(PedidoService service) {
        this.service = service;
    }

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void gerarPedidos() {
        service.save(new Pedido(
                UUID.randomUUID(),
                UUID.randomUUID(),
                List.of(new Item(1L, new BigDecimal(5)))
        ));
    }
}
