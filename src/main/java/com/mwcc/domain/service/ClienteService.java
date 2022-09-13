package com.mwcc.domain.service;

import com.mwcc.api.exception.EntidadeNaoEncontradaException;
import com.mwcc.domain.entity.Cliente;
import com.mwcc.domain.repository.Clientes;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

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
