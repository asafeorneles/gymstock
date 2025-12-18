package com.asafeorneles.gym_stock_control.dtos.analytics;

import java.math.BigDecimal;

public record TopSellingProductsDto(
        String productId,
        String productName,
        BigDecimal quantitySold
) {
}
