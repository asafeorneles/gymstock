package com.asafeorneles.gym_stock_control.exceptions;

public class ProductInventoryNotFoundException extends RuntimeException {
    public ProductInventoryNotFoundException(String message) {
        super(message);
    }

}
