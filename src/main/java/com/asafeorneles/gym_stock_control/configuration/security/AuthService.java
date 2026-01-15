package com.asafeorneles.gym_stock_control.configuration.security;

import com.asafeorneles.gym_stock_control.dtos.user.LoginRequest;
import com.asafeorneles.gym_stock_control.dtos.user.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    public LoginResponse login(LoginRequest loginRequest) {

       Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                )
        );

        String token = tokenService.generateToken(authentication);

        return new LoginResponse(token, tokenService.getTokenExpiresIn());
    }
}
