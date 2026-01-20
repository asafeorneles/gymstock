package com.asafeorneles.gym_stock_control.dtos.user;

import java.util.UUID;

public record SoldByUserDto (
        String username,
        UUID userId
){
}
