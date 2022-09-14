package com.mwcc.api.controller;

import com.mwcc.domain.dto.PedidoDTO;
import com.mwcc.domain.entity.Pedido;
import com.mwcc.domain.repository.Pedidos;
import com.mwcc.domain.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @AllArgsConstructor
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final Pedidos pedidos;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO dto){
        Pedido pedido = pedidoService.salvar(dto);
        return pedido.getId();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pedido> getPedidos(Pedido pedidoFiltro){

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING
                );

        Example example = Example.of(pedidoFiltro, matcher);
        List<Pedido> lista = pedidos.findAll(example);
        return lista;
    }
}
