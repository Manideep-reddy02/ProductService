package com.example.productservice.Exceptions;

import java.util.StringJoiner;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException() {

    }
    public ProductNotFoundException(String message){
        super(message);

    }

}
