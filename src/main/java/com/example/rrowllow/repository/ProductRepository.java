package com.example.rrowllow.repository;

import com.example.rrowllow.entity.shop.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //세일 여부
    boolean existsBysale(String productName);
}
