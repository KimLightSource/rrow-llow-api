package com.example.rrowllow.dto.article;

import com.example.rrowllow.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleResponseDto {
    private Long articleId;
    private String memberNickname;
    private String articleTitle;
    private String articleBody;
    private String createdAt;
    private String updatedAt;
    private boolean isWritten;

    public static ArticleResponseDto of(Article article, boolean bool) {
        return ArticleResponseDto.builder()
                                 .articleId(article.getId())
                .memberNickname(article.getMember().getNickname())
                .articleTitle(article.getTitle())
                .articleBody(article.getBody())
                .createdAt(article.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .updatedAt(article.getLastModifiedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .isWritten(bool)
                .build();
    }
}
