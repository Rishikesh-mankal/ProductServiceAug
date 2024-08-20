package com.rishi.productservice15aug.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException() {

    }
    public ProductNotFoundException(String message) {
        super(message);
    }
}
