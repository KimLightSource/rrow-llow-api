package com.example.rrowllow.dto;


import com.example.rrowllow.entity.Article;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
public class PageResponseDto {
    private Long articleId;
    private String articleTitle;
    private String memberNickname;
    private LocalDateTime createdAt;

    public static PageResponseDto of(Article article) {
        return PageResponseDto.builder()
                              .articleId(article.getId())
                              .articleTitle(article.getTitle())
                              .memberNickname(article.getMember().getNickname())
                              .createdAt(article.getCreatedDate())
                              .build();
    }
}
