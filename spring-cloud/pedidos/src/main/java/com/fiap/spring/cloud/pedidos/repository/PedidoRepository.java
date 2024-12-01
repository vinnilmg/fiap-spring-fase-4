package com.fiap.spring.cloud.pedidos.repository;

import com.fiap.spring.cloud.pedidos.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
    Optional<Pedido> findByClienteId(UUID clienteId);
}
