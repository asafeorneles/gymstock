package com.asafeorneles.gym_stock_control.mapper;

import com.asafeorneles.gym_stock_control.dtos.category.ResponseCategoryDto;
import com.asafeorneles.gym_stock_control.dtos.product.ResponseProductDto;
import com.asafeorneles.gym_stock_control.entities.Product;

public class ProductMapper {
    public static ResponseProductDto productToResponseProduct(Product product) {
        return new ResponseProductDto(
                product.getName(),
                product.getBrand(),
                product.getPrice(),
                product.getCostPrice(),
                new ResponseCategoryDto(product.getCategory().getCategoryId(), product.getCategory().getName(), product.getCategory().getDescription()),
                product.getInventory().getQuantity(),
                product.getInventory().getLowStockThreshold()
        );
    }
}
