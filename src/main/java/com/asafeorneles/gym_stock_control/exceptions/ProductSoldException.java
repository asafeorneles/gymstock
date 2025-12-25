package com.asafeorneles.gym_stock_control.exceptions;

public class ProductSoldException extends RuntimeException {
    public ProductSoldException(String message) {
        super(message);
    }
}
