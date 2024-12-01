package com.fiap.spring.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigGateway {

    @Bean
    public RouteLocator custom(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("estoque", r -> r.path("/estoque/**")
                        .and()
                        .not(p -> p.path("/estoque/api/**"))
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8082"))
                .route("pedidos", r -> r.path("/pedidos/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8081"))
                .build();
    }
}
