package com.example.rrowllow.service;

import com.example.rrowllow.dto.shop.ProductResponseDto;
import com.example.rrowllow.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private ProductRepository productRepository;

    @Transactional
    public ProductResponseDto changeDescription() {

    }
}
