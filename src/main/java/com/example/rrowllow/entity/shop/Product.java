package com.example.rrowllow.entity.shop;

import com.example.rrowllow.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY")
    private Category category;

    //세일 %
    @Column
    private int sale;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int price;

    //판매량
    @Column
    private int salesVolume;

    @Column
    private String description;

    @Column
    private String imgPath;

    public void changeDescription(String description) {
        this.description = description;
    }
    public void changeSalePercentage(int salePercentage) {
        this.sale = salePercentage;
    }

    public static Product registerProduct(String productName, Category category, int sale, int amount, int price, String description, String imgPath) {
        Product product = new Product();
        product.productName = productName;
        product.category = category;
        product.sale = sale;
        product.amount = amount;
        product.price = price;
        product.description = description;
        product.imgPath = imgPath;
        return product;
    }
}
