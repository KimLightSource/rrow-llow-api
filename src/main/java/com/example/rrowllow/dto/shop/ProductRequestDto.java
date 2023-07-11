package com.example.rrowllow.dto.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private String productName;
    private int amount;
    private int price;
    private int sale;
    private String category;
    private String description;
    private String imgPath;
}
