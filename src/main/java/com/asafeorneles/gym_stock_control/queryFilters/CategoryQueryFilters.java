package com.asafeorneles.gym_stock_control.queryFilters;

import com.asafeorneles.gym_stock_control.entities.Category;
import com.asafeorneles.gym_stock_control.enums.ActivityStatus;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import static com.asafeorneles.gym_stock_control.specifications.CategorySpec.activityStatusEquals;
import static com.asafeorneles.gym_stock_control.specifications.CategorySpec.nameContains;

@Data
public class CategoryQueryFilters {
    private String name;
    private ActivityStatus activityStatus;

    public Specification<Category> toSpecification() {

        return nameContains(name).and(activityStatusEquals(activityStatus));
    }
}
