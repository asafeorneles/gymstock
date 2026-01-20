package com.asafeorneles.gym_stock_control.mapper;

import com.asafeorneles.gym_stock_control.dtos.coupon.CouponAppliedDto;
import com.asafeorneles.gym_stock_control.dtos.sale.CreateSaleDto;
import com.asafeorneles.gym_stock_control.dtos.sale.ResponseSaleDto;
import com.asafeorneles.gym_stock_control.dtos.user.SoldByUserDto;
import com.asafeorneles.gym_stock_control.entities.Sale;
import com.asafeorneles.gym_stock_control.entities.User;

public class SaleMapper {
    public static Sale createSaleToSale(CreateSaleDto createSaleDto, User user) {
        return Sale.builder()
                .paymentMethod(createSaleDto.paymentMethod())
                .user(user)
                .build();
    }

    public static ResponseSaleDto saleToResponseSale(Sale sale) {
        if (sale.containsCoupon()) {
            return new ResponseSaleDto(
                    sale.getSaleId(),
                    SaleItemMapper.saleItemsToResponseSaleItems(sale.getSaleItems()),
                    new CouponAppliedDto(sale.getCoupon().getCode(), sale.getDiscountAmount()),
                    sale.getTotalPrice(),
                    sale.getPaymentMethod(),
                    new SoldByUserDto(sale.getUser().getUsername(), sale.getUser().getUserId()),
                    sale.getCreatedDate()
            );
        }

        return new ResponseSaleDto(
                sale.getSaleId(),
                SaleItemMapper.saleItemsToResponseSaleItems(sale.getSaleItems()),
                null,
                sale.getTotalPrice(),
                sale.getPaymentMethod(),
                new SoldByUserDto(sale.getUser().getUsername(), sale.getUser().getUserId()),
                sale.getCreatedDate()
        );
    }
}

