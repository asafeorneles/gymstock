package com.asafeorneles.gym_stock_control.configuration.security;

import com.asafeorneles.gym_stock_control.entities.Role;
import com.asafeorneles.gym_stock_control.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class TokenService {

    @Autowired
    JwtEncoder jwtEncoder;

    @Value("${jwt.expiration}")
    private long expiresIn;

    public String generateToken(User user){

        String scopes = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.joining(" "));

        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("gym-stock-api")
                .subject(user.getUserId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("scopes", scopes)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}
