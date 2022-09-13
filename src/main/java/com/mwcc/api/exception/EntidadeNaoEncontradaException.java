package com.mwcc.api.exception;

import java.util.function.Supplier;

public class EntidadeNaoEncontradaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(String message){
        super(message);
    }


}
