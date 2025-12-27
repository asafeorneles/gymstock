package com.asafeorneles.gym_stock_control.dtos.category;

import com.asafeorneles.gym_stock_control.enums.ActivityStatus;

import java.util.UUID;

public record ResponseCategoryDetailsDto(
        UUID categoryId,
        String name,
        String description,
        ActivityStatus activityStatus
) {
}
