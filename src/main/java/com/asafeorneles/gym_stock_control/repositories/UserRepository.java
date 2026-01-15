package com.asafeorneles.gym_stock_control.repositories;

import com.asafeorneles.gym_stock_control.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByRoles_Name(String roleName);
    Optional<User> findByUsername(String username);
}
