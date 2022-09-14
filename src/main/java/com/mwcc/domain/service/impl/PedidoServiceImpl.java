package com.mwcc.domain.service.impl;

import com.mwcc.domain.repository.Pedidos;
import com.mwcc.domain.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos pedidos;


}
