package com.asafeorneles.gym_stock_control.controllers;

import com.asafeorneles.gym_stock_control.dtos.category.CreateCategoryDto;
import com.asafeorneles.gym_stock_control.dtos.category.ResponseCategoryDto;
import com.asafeorneles.gym_stock_control.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/categories")
    public ResponseEntity<ResponseCategoryDto> createCategory(@RequestBody @Valid CreateCategoryDto createCategoryDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(createCategoryDto));
    }
}
