package com.asafeorneles.gym_stock_control.services;

import com.asafeorneles.gym_stock_control.dtos.category.CreateCategoryDto;
import com.asafeorneles.gym_stock_control.dtos.category.ResponseCategoryDto;
import com.asafeorneles.gym_stock_control.dtos.category.UpdateCategoryDto;
import com.asafeorneles.gym_stock_control.entities.Category;
import com.asafeorneles.gym_stock_control.exceptions.CategoryNotFoundException;
import com.asafeorneles.gym_stock_control.mapper.CategoryMapper;
import com.asafeorneles.gym_stock_control.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ResponseCategoryDto createCategory(CreateCategoryDto createCategoryDto){
        Category newCategory = CategoryMapper.createCategoryToCategory(createCategoryDto);
        categoryRepository.save(newCategory);
        return CategoryMapper.categoryToResponseCategory(newCategory);
    }

    public List<ResponseCategoryDto> findCategory() {
        List<Category> categoriesFound = categoryRepository.findAll();
        if (categoriesFound.isEmpty()){
            throw new CategoryNotFoundException("Categories not found or do not exist");
        }
        return categoriesFound.stream().map(CategoryMapper::categoryToResponseCategory).toList();
    }

    public ResponseCategoryDto findCategoryById(UUID id) {
        Category categoryFound = categoryRepository
                .findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found by id: " + id));
        return CategoryMapper.categoryToResponseCategory(categoryFound);
    }

    public ResponseCategoryDto updateCategory(UUID id, UpdateCategoryDto updateCategoryDto) {
        Category categoryFound = categoryRepository
                .findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found by id: " + id));

        CategoryMapper.updateCategoryToCategory(categoryFound, updateCategoryDto);

        categoryRepository.save(categoryFound);

        return CategoryMapper.categoryToResponseCategory(categoryFound);
    }

    public void deleteCategory(UUID id) {
        Category categoryFound = categoryRepository
                .findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found by id: " + id));

        categoryRepository.delete(categoryFound);
    }
}
