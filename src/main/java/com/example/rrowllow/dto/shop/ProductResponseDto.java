package com.example.rrowllow.dto.shop;

import com.example.rrowllow.entity.shop.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {
    private String createdDate;
    private String productName;
    private String description;
    private String img;
    private int amount;
    private int price;
    private int sale;
    private int salesVolume;

    public static ProductResponseDto of(Product product) {
        return ProductResponseDto.builder()
                .createdDate(product.getCreatedDate().toString())
                .productName(product.getProductName())
                .description(product.getDescription())
                .amount(product.getAmount())
                .price(product.getPrice())
                .img(product.getImgPath())
                .sale(product.getSale())
                .salesVolume(product.getSalesVolume())
                .build();
    }

}
