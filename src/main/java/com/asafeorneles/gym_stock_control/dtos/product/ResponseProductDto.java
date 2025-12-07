package com.asafeorneles.gym_stock_control.dtos.product;

import com.asafeorneles.gym_stock_control.dtos.category.ResponseCategoryDto;

import java.math.BigDecimal;

public record ResponseProductDto(
        String name,
        String brand,
        BigDecimal price,
        BigDecimal costPrice,
        ResponseCategoryDto responseCategoryDto,
        int quantity,
        int lowStockThreshold

) {
}
