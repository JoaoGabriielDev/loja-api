package br.com.store.exceptions;

public class ProdutoNotFoundException extends RuntimeException{

    public ProdutoNotFoundException() {
        super("Produto não foi encontrado");
    }

    public ProdutoNotFoundException(String message){
        super(message);
    }
}

