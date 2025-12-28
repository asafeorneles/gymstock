package com.asafeorneles.gym_stock_control.specifications;

import com.asafeorneles.gym_stock_control.entities.Category;
import com.asafeorneles.gym_stock_control.entities.Coupon;
import com.asafeorneles.gym_stock_control.enums.ActivityStatus;
import com.asafeorneles.gym_stock_control.enums.DiscountType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

public class CategorySpec {

    public static Specification<Category> nameContains(String name){
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(name)){
                return null;
            }
            return builder.like(root.get("name"), "%" + name + "%");
        };
    }

    public static Specification<Category> activityStatusEquals(ActivityStatus activityStatus){
        return (root, query, builder) -> {
            if (ObjectUtils.isEmpty(activityStatus)){
                return null;
            }
            return builder.equal(root.get("activityStatus"), activityStatus);
        };
    }
}
