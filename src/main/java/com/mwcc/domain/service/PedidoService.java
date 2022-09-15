package com.mwcc.domain.service;

import com.mwcc.domain.dto.PedidoDTO;
import com.mwcc.domain.entity.Pedido;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO pedidoDTO);
    Optional<Pedido> obterPedidoCompleto(Integer idPedido);
}
