package com.asafeorneles.gym_stock_control.configuration.security;

import com.asafeorneles.gym_stock_control.dtos.user.LoginRequest;
import com.asafeorneles.gym_stock_control.dtos.user.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = authService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }
}
