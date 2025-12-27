package com.asafeorneles.gym_stock_control.entities;

import com.asafeorneles.gym_stock_control.enums.ActivityStatus;
import com.asafeorneles.gym_stock_control.exceptions.CouponAlreadyActiveException;
import com.asafeorneles.gym_stock_control.exceptions.ProductAlreadyInactivityException;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private UUID categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "activity_status")
    @Enumerated(EnumType.STRING)
    private ActivityStatus activityStatus;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public void inactivity(){
        if (this.activityStatus == ActivityStatus.INACTIVITY){
            throw new ProductAlreadyInactivityException("Category is already inactive!");
        }
        this.activityStatus = ActivityStatus.INACTIVITY;
    }

    public void activity(){
        if (this.activityStatus == ActivityStatus.ACTIVE){
            throw new CouponAlreadyActiveException("Category is already active!");
        }
        this.activityStatus = ActivityStatus.ACTIVE;
    }

    @PrePersist
    public void prePersist(){
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
