package com.mwcc.domain.repository;

import com.mwcc.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    Optional<Pedido> findByIdFetchItens(Integer id);
}
