package com.example.rrowllow.service;

import com.example.rrowllow.dto.PageResponseDto;
import com.example.rrowllow.entity.Article;
import com.example.rrowllow.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<PageResponseDto> allArticle() {
        List<Article> articles = articleRepository.findAll();
        return articles
                .stream()
                .map(PageResponseDto::of)
                .collect(Collectors.toList());
    }
}
