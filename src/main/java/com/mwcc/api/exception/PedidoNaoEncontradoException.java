package com.mwcc.api.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
    public PedidoNaoEncontradoException(){
        super("Pedido não encontrado.");
    }
}
