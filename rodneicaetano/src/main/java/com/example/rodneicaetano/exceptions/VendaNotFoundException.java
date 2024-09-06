package com.example.rodneicaetano.exceptions;

public class VendaNotFoundException extends RuntimeException {
    public VendaNotFoundException(String message) {
        super(message);
    }
}
