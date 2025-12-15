package com.asafeorneles.gym_stock_control.dtos.SaleItem;

import java.util.UUID;

public record CreateSaleItemDto (
        UUID productId,
        int quantity
){
}
