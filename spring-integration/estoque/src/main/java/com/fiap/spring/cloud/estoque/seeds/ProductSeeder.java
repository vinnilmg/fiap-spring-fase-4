package com.fiap.spring.cloud.estoque.seeds;

import com.fiap.spring.cloud.estoque.domain.Produto;
import com.fiap.spring.cloud.estoque.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class ProductSeeder {
    private final ProdutoRepository repository;

    public ProductSeeder(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Bean
    public CommandLineRunner initProducts() {
        System.out.println("Incluindo produtos");
        return args -> {
            List<Produto> products = List.of(
                    new Produto(1L, "Camiseta", BigDecimal.valueOf(100)),
                    new Produto(2L, "Mouse", BigDecimal.valueOf(5))
            );
            repository.saveAll(products);
        };
    }
}
