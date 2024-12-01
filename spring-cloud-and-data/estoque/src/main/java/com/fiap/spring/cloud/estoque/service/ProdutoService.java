package com.fiap.spring.cloud.estoque.service;

import com.fiap.spring.cloud.estoque.domain.Produto;
import com.fiap.spring.cloud.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> findAll() {
        return this.repository.findAll();
    }

    public void removerEstoque(final Long produtoId, final BigDecimal quantidade) {
        final var produto = repository.findById(produtoId)
                .orElseThrow(() -> new IllegalArgumentException("Produto nao encontrado"));

        produto.removerEstoque(quantidade);
        repository.save(produto);
    }
}
