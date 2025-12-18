package com.asafeorneles.gym_stock_control.repositories;

import com.asafeorneles.gym_stock_control.dtos.analytics.TopSellingProductsDto;
import com.asafeorneles.gym_stock_control.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnalyticsRepository extends JpaRepository<Product, UUID> {

    @Query(value =
            """
            SELECT BIN_TO_UUID(SI.product_id) AS productId, P.name AS productName, SUM(SI.quantity) AS quantitySold
            FROM gym_stock_control_api.tb_sale_itens SI
            INNER JOIN gym_stock_control_api.tb_products P ON SI.product_id = P.product_id
            GROUP BY SI.product_id, P.name
            ORDER BY quantitySold DESC
            LIMIT :limit
            """,
            nativeQuery = true
    )
    List<TopSellingProductsDto> findTopSellingProducts(@Param(value = "limit") int limit);
}