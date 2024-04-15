package com.Microservices.EComProductService.exception;

public class NoProductPresentException extends RuntimeException{
    public NoProductPresentException(String message) {
        super(message);
    }
}
