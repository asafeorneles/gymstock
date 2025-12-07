package com.asafeorneles.gym_stock_control.repositories;

import com.asafeorneles.gym_stock_control.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
