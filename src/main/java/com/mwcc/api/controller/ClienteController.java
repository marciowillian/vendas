package com.mwcc.api.controller;

import com.mwcc.domain.entity.Cliente;
import com.mwcc.domain.repository.Clientes;
import com.mwcc.domain.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final Clientes clientes;
    private final ClienteService clienteService;

    @GetMapping("{id}")
    public Cliente getClienteById(@PathVariable Integer id) {
        return clientes.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clientes.save(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable Integer id) {
        clienteService.deletar(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente update(@PathVariable Integer id, @RequestBody Cliente cliente){

        return clientes
                .findById(id)
                .map(clienteExixtente -> {
                    cliente.setId(clienteExixtente.getId());
                    clientes.save(cliente);
                    return cliente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Cliente não encontrado."));

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> find(Cliente clienteFiltro){

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING
                );

        Example example = Example.of(clienteFiltro, matcher);
        List<Cliente> lista = clientes.findAll(example);
        return lista;
    }

}
