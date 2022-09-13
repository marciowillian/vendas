package com.mwcc.domain.service;

import com.mwcc.domain.entity.Produto;

public interface ProdutoService {
    void delete(Integer produtoId);
    Produto getById(Integer id);
}
