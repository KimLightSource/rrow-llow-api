package com.example.rrowllow.controller;

import com.example.rrowllow.dto.shop.ProductRequestDto;
import com.example.rrowllow.dto.shop.ProductResponseDto;
import com.example.rrowllow.service.shop.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductResponseDto>> getProductLists() {
        return ResponseEntity.ok(productService.productList());
    }

    @PostMapping("/")
    public ResponseEntity<ProductResponseDto> postProduct(ProductRequestDto productRequest) {
        return ResponseEntity.ok(productService.registerProduct(productRequest));
    }

    @PutMapping("/decription")
    public ResponseEntity<ProductResponseDto> changeDecription(ProductRequestDto productRequest) {
        return ResponseEntity.ok(productService.changeDescription(productRequest));
    }

    @PutMapping("/sale")
    public ResponseEntity<ProductResponseDto> changeSalePercent(ProductRequestDto productRequest) {
        return ResponseEntity.ok(productService.changeSale(productRequest));
    }


}
