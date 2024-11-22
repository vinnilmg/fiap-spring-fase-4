package com.fiap.spring.cloud.estoque.service;

import com.fiap.spring.cloud.estoque.domain.Produto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {
    private List<Produto> fakeDb = List.of(
            new Produto(1L, "Camiseta", BigDecimal.valueOf(20)),
            new Produto(2L, "Mouse", BigDecimal.valueOf(5))
    );

    public List<Produto> findAll() {
        return this.fakeDb;
    }
}
