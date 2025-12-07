package com.asafeorneles.gym_stock_control.services;

import com.asafeorneles.gym_stock_control.dtos.category.ResponseCategoryDto;
import com.asafeorneles.gym_stock_control.dtos.product.CreateProductDto;
import com.asafeorneles.gym_stock_control.dtos.product.ResponseProductDto;
import com.asafeorneles.gym_stock_control.entities.Category;
import com.asafeorneles.gym_stock_control.entities.Product;
import com.asafeorneles.gym_stock_control.repositories.CategoryRepository;
import com.asafeorneles.gym_stock_control.repositories.ProductRepository;
import com.asafeorneles.gym_stock_control.services.factory.ProductInventoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public ResponseProductDto createProduct(CreateProductDto createProductDto) {
        Category category = categoryRepository.findById(createProductDto.category_id())
                .orElseThrow(() -> new ErrorResponseException(HttpStatus.NOT_FOUND));

        var product = Product.builder()
                .name(createProductDto.name())
                .brand(createProductDto.brand())
                .price(createProductDto.price())
                .costPrice(createProductDto.costPrice())
                .category(category)
                .build();

        var productInventory = ProductInventoryFactory
                .newProductInventory(product, createProductDto.quantity(), createProductDto.lowStockThreshold());

        product.setInventory(productInventory);
        productRepository.save(product);

        return new ResponseProductDto(
                product.getName(),
                product.getBrand(),
                product.getPrice(),
                product.getCostPrice(),
                new ResponseCategoryDto(category.getCategoryId(), category.getName(), category.getDescription()),
                productInventory.getQuantity(),
                productInventory.getLowStockThreshold());
    }
}
