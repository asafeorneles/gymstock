package com.asafeorneles.gym_stock_control.dtos.product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateProductDto(
        @NotBlank(message = "The name cannot be empty!")
        @Size(min = 2, max = 100, message = "The name should be between 2 and 100 characters")
        String name,
        @NotBlank(message = "The brand cannot be empty!")
        @Size(min = 2, max = 100, message = "The brand should be between 2 and 100 characters!")
        String brand,
        @NotNull(message = "The price is mandatory!")
        @DecimalMin(value = "0.01", message = "The min price is 0.01!")
        BigDecimal price,
        @NotNull(message = "The cost price is mandatory!")
        @DecimalMin(value = "0.01", message = "The min cost price is 0.01!")
        BigDecimal costPrice,
        @NotNull(message = "The category is mandatory!")
        UUID category_id,
        @NotNull(message = "The quantity cannot be null!")
        @DecimalMin(value = "1", message = "The min quantity is 1!")
        int quantity,
        @NotNull(message = "The low stock threshold cannot be null!")
        @DecimalMin(value = "1", message = "The low stock threshold cannot be less than 1!")
        int lowStockThreshold
) {
}
