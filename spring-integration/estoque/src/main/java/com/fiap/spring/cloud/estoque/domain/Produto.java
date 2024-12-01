package com.fiap.spring.cloud.estoque.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Produto {

    @MongoId
    private Long id;

    private String nome;

    private BigDecimal quantidade;

    public void removerEstoque(final BigDecimal quantidade) {
        if (quantidade.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Quantidade inválida");
        } else if (this.quantidade.compareTo(quantidade) == -1) {
            throw new UnsupportedOperationException("Estoque insuficiente");
        }

        this.quantidade = this.quantidade.subtract(quantidade);
    }
}
