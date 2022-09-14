package com.mwcc.domain.service.impl;

import com.mwcc.domain.repository.Clientes;
import com.mwcc.domain.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final Clientes clientes;

    public void deletar (Integer clienteId){
        clientes.findById(clienteId)
                .map(cliente -> {
                    clientes.delete(cliente);
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

    }

}
