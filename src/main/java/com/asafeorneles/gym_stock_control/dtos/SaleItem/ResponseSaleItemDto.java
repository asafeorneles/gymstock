package com.asafeorneles.gym_stock_control.dtos.SaleItem;

import com.asafeorneles.gym_stock_control.dtos.product.ResponseProductDto;

import java.math.BigDecimal;
import java.util.UUID;

public record ResponseSaleItemDto(
        UUID saleItemId,
        UUID productId, // Or only product name
        String nameProduct,
        int quantity,
        BigDecimal unityPrice,
        BigDecimal totalPrice
) {
}
