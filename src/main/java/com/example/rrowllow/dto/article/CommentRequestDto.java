package com.example.rrowllow.dto.article;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long articleId;
    private String body;
}
