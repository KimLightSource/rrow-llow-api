package com.example.rrowllow.service.shop;

import com.example.rrowllow.config.SecurityUtil;
import com.example.rrowllow.dto.shop.ProductRequestDto;
import com.example.rrowllow.dto.shop.ProductResponseDto;
import com.example.rrowllow.entity.Member;
import com.example.rrowllow.entity.UserRole;
import com.example.rrowllow.entity.shop.Category;
import com.example.rrowllow.entity.shop.Product;
import com.example.rrowllow.repository.CategoryRepository;
import com.example.rrowllow.repository.MemberRepository;
import com.example.rrowllow.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private MemberRepository memberRepository;

    public List<ProductResponseDto> productList() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new RuntimeException("등록된 상품이 없습니다.");
        }
        List<ProductResponseDto> productResponseDtos = products.stream().map(ProductResponseDto::of).toList();
        return productResponseDtos.stream().sorted(Comparator.comparing(ProductResponseDto::getCreatedAt)).toList();
    }

    @Transactional
    public ProductResponseDto registerProduct(ProductRequestDto productRequestDto) {
        if (productRepository.existsByProductName(productRequestDto.getProductName())) {
            throw new RuntimeException("이미 등록되어 있는 상품명입니다.");
        }
        Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId()).orElseThrow();
        if (member.getUserRole() != UserRole.ADMIN) {
            throw new RuntimeException("관리자 계정이 아닙니다.");
        }
        Category category = categoryRepository.findByCategory(productRequestDto.getCategory()).orElseThrow(() -> new RuntimeException("존재하지 않는 카테고리입니다."));
        Product product = Product.registerProduct(
                productRequestDto.getProductName(),
                category,
                productRequestDto.getSale(),
                productRequestDto.getAmount(),
                productRequestDto.getPrice(),
                productRequestDto.getDescription(),
                productRequestDto.getImgPath()
        );
        return ProductResponseDto.of(productRepository.save(product));
    }


    @Transactional
    public ProductResponseDto changeDescription(ProductRequestDto productRequestDto) {
        Product product = productRepository.findByProductName(productRequestDto.getProductName()).orElseThrow(() -> new RuntimeException("존재하지 않는 상품입니다."));
        product.changeDescription(productRequestDto.getDescription());
        return ProductResponseDto.of(product);
    }

    @Transactional
    public ProductResponseDto changeSale(ProductRequestDto productRequestDto) {
        Product product = productRepository.findByProductName(productRequestDto.getProductName()).orElseThrow(() -> new RuntimeException("존재하지 않는 상품입니다."));
        product.changeSalePercentage(productRequestDto.getSale());
        return ProductResponseDto.of(product);
    }
}
