package com.fiap.spring.cloud.pedidos.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long produtoId;

    private BigDecimal quantidade;

    public Item(Long produtoId, BigDecimal quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }
}
