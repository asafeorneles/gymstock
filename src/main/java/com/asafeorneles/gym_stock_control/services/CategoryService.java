package com.asafeorneles.gym_stock_control.services;

import com.asafeorneles.gym_stock_control.dtos.category.CreateCategoryDto;
import com.asafeorneles.gym_stock_control.dtos.category.ResponseCategoryDto;
import com.asafeorneles.gym_stock_control.entities.Category;
import com.asafeorneles.gym_stock_control.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ResponseCategoryDto createCategory(CreateCategoryDto createCategoryDto){
        var category = new Category();
        BeanUtils.copyProperties(createCategoryDto, category);
        categoryRepository.save(category);
        return new ResponseCategoryDto(
                category.getCategoryId(),
                category.getName(),
                category.getDescription());
    }
}
