package com.fiap.spring.cloud.estoque.consumer;

import com.fiap.spring.cloud.estoque.consumer.dto.ProdutoRequest;
import com.fiap.spring.cloud.estoque.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class ProdutoConsumer {

    private final ProdutoService service;

    public ProdutoConsumer(ProdutoService service) {
        this.service = service;
    }

    @Bean(name = "remove-estoque")
    Consumer<ProdutoRequest> consumer() {
        return produtoRequest -> service.removerEstoque(
                produtoRequest.getId(),
                produtoRequest.getQuantidade()
        );
    }
}
