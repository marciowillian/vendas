package com.mwcc.domain.service;

import com.mwcc.domain.entity.Produto;
import com.mwcc.domain.repository.Produtos;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService{
    private final Produtos produtos;

    private static final String MSG_PRODUTO_NAO_ENCONTRADO = "Produto não encontrado.";

    public void delete(Integer produtoId){
        produtos.findById(produtoId)
                .map(produto -> {
                    produtos.delete(produto);
                    return produto;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, MSG_PRODUTO_NAO_ENCONTRADO));
    }

    public Produto getById(Integer id){
        return produtos.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, MSG_PRODUTO_NAO_ENCONTRADO));
    }
}
