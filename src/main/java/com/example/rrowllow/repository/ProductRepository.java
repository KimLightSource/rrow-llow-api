package com.example.rrowllow.repository;

import com.example.rrowllow.entity.shop.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByProductName(String productName);
    Optional<Product> findByProductName(String productName);
}
