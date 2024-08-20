package com.rishi.productservice15aug.exceptions;

public class InvalidProductIdException extends Exception{
    public InvalidProductIdException(){

    }
    public InvalidProductIdException(String message){
        super(message);
    }
}
