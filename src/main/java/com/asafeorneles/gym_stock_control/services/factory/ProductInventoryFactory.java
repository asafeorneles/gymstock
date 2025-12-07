package com.asafeorneles.gym_stock_control.services.factory;

import com.asafeorneles.gym_stock_control.entities.Product;
import com.asafeorneles.gym_stock_control.entities.ProductInventory;

public class ProductInventoryFactory {
    public static ProductInventory newProductInventory(Product product, int quantity, int lowStockThreshold) {
        return ProductInventory.builder()
                .product(product)
                .quantity(quantity)
                .lowStockThreshold(lowStockThreshold)
                .build();
    }
}
