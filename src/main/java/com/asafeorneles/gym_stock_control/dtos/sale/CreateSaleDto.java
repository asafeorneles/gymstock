package com.asafeorneles.gym_stock_control.dtos.sale;

import com.asafeorneles.gym_stock_control.dtos.SaleItem.CreateSaleItemDto;
import com.asafeorneles.gym_stock_control.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateSaleDto(
        @NotNull(message = "The list of sale items cannot be null!")
        List<CreateSaleItemDto> saleItems,
        @NotNull(message = "The payment method of sale items cannot be null!")
        PaymentMethod paymentMethod
) {

}
