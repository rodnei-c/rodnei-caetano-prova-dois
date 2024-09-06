package com.example.rodneicaetano.exceptions;

public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(String message) {
        super(message);
    }
}
