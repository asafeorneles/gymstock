package com.asafeorneles.gym_stock_control.services;

import com.asafeorneles.gym_stock_control.dtos.analytics.TopSellingProductsDto;
import com.asafeorneles.gym_stock_control.repositories.AnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.List;

@Service
public class AnalyticsService {

    @Autowired
    AnalyticsRepository analyticsRepository;

    public List<TopSellingProductsDto> getTopSellingProducts(Integer limit){

        int finalLimit = (limit == null || limit < 0) ? 10 : Math.min(limit, 30);

        List<TopSellingProductsDto> topSellingProducts = analyticsRepository.findTopSellingProducts(finalLimit);
        if (topSellingProducts.isEmpty()){
            throw new ErrorResponseException(HttpStatus.NOT_FOUND); // Create an Exception Handler for when Pet is not found
        }
        return topSellingProducts;
    }
}
