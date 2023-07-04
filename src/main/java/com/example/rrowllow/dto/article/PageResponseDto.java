package com.example.rrowllow.dto.article;


import com.example.rrowllow.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponseDto {
    private Long articleId;
    private String articleTitle;
    private String memberNickname;
    private String createdAt;

    public static PageResponseDto of(Article article) {
        return PageResponseDto.builder()
                              .articleId(article.getId())
                              .articleTitle(article.getTitle())
                              .memberNickname(article.getMember().getNickname())
                              .createdAt(article.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                              .build();
    }
}
