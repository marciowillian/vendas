package com.mwcc.api.controller;

import com.mwcc.domain.entity.Produto;
import com.mwcc.domain.repository.Produtos;
import com.mwcc.domain.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController @AllArgsConstructor
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final Produtos produtos;
    private final ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto createProduto(@RequestBody @Valid Produto produto){
        return produtos.save(produto);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto getProdutoById(@PathVariable Integer id){
        return produtoService.getById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        produtoService.delete(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto update(@PathVariable Integer id, @RequestBody @Valid Produto produto){
        return produtos
                .findById(id)
                .map(produtoExistente -> {
                    produto.setId(produtoExistente.getId());
                    produtos.save(produto);
                    return produto;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Produto não encontrado."));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> getProdutoFiltro(Produto produtoFiltro){

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING
                );

        Example example = Example.of(produtoFiltro, matcher);
        List<Produto> lista = produtos.findAll(example);
        return lista;
    }
}
