package com.asafeorneles.gym_stock_control.entities;

import com.asafeorneles.gym_stock_control.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_sale_product_history")
@Getter
@Setter
@NoArgsConstructor
public class SaleProductHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sale_product_history_id")
    private UUID saleProductHistoryId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "cost_price")
    private BigDecimal costPrice;

    @Column(name = "unity_price")
    private BigDecimal unityPrice;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @Column(name = "sale_date")
    private LocalDateTime saleDate;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @PrePersist
    public void prePersist() {
        this.saleDate = LocalDateTime.now();
    }

    public SaleProductHistory(PaymentMethod paymentMethod, Sale sale, BigDecimal costPrice, BigDecimal totalPrice, int quantity, Product product) {
        this.paymentMethod = paymentMethod;
        this.sale = sale;
        this.costPrice = costPrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.product = product;
    }
}
