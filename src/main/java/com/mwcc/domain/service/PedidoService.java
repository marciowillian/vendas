package com.mwcc.domain.service;

import com.mwcc.domain.dto.PedidoDTO;
import com.mwcc.domain.entity.Pedido;

public interface PedidoService {
    Pedido salvar(PedidoDTO pedidoDTO);
}
