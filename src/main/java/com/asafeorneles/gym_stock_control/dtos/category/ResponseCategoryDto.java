package com.asafeorneles.gym_stock_control.dtos.category;

import java.util.UUID;

public record ResponseCategoryDto(
        UUID categoryId,
        String name,
        String description
) {
}
