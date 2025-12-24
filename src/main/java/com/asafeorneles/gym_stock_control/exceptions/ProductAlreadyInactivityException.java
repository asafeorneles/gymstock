package com.asafeorneles.gym_stock_control.exceptions;

public class ProductAlreadyInactivityException extends RuntimeException {
    public ProductAlreadyInactivityException(String message) {
        super(message);
    }
}
