package com.fiap.spring.cloud.estoque.repository;

import com.fiap.spring.cloud.estoque.domain.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, Long> {
}
