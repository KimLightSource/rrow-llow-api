package com.example.rrowllow.dto.article;

import com.example.rrowllow.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentResponseDto {
    private long commentId;
    private String memberNickname;
    private String commentBody;
    private String createdAt;
    private boolean isWritten; //로그인한 멤버가 작성을 하였는지 여부

    public static CommentResponseDto of(Comment comment, boolean bool) {
        return CommentResponseDto.builder()
                                 .commentId(comment.getId())
                                 .memberNickname(comment.getMember().getNickname())
                                 .commentBody(comment.getText())
                                 .createdAt(comment.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                                 .isWritten(bool)
                                 .build();
    }
}
