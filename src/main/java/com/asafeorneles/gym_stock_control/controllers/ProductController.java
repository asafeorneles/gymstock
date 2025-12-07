package com.asafeorneles.gym_stock_control.controllers;

import com.asafeorneles.gym_stock_control.dtos.product.CreateProductDto;
import com.asafeorneles.gym_stock_control.dtos.product.ResponseProductDto;
import com.asafeorneles.gym_stock_control.entities.Product;
import com.asafeorneles.gym_stock_control.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ResponseProductDto> createProduct (@RequestBody @Valid CreateProductDto createProductDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(createProductDto));
    }
}
