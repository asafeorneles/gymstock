package com.asafeorneles.gym_stock_control.dtos.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ResponseExceptionValidation(
        int code,
        String error,
        String message,
        LocalDateTime timestamp,
        Map<String, String> fieldErrors
){
}
