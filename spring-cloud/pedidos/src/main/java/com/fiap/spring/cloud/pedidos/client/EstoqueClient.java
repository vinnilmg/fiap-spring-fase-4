package com.fiap.spring.cloud.pedidos.client;

import com.fiap.spring.cloud.pedidos.client.request.RemoverEstoqueRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "estoque", url = "http://localhost:8082/api")
public interface EstoqueClient {

    @PostMapping(value = "/consumer/remove-estoque")
    void removerEstoque(RemoverEstoqueRequest request);
}
