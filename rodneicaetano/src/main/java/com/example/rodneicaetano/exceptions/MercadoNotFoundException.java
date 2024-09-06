package com.example.rodneicaetano.exceptions;

public class MercadoNotFoundException extends RuntimeException{

    public MercadoNotFoundException(){
        super("Esse mercado não existe");
    }

}
