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

}
