package com.example.rrowllow.repository;

import com.example.rrowllow.dto.article.PageResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleRepositoryCustom {
    Page<PageResponseDto> searchAll(Pageable pageable);
}
