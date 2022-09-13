package com.mwcc.domain.repository;

import com.mwcc.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String nome);

    @Query(value = "select c from Cliente c where c.nome like " + "%" + ":nome" + "%")
    List<Cliente> econtrarPorNome(@Param("nome") String nome);

    List<Cliente> findByNomeOrId(String nome, Integer id);

    boolean existsByNome(String nome);

    @Query("select c from Cliente c left join fetch c.pedidos where c.id = :id")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);

}
