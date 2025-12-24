package com.asafeorneles.gym_stock_control.exceptions;

public class ProductAlreadyActiveException extends RuntimeException {
    public ProductAlreadyActiveException(String message) {
        super(message);
    }
}
