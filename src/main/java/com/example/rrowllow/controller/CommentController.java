package com.example.rrowllow.controller;

import com.example.rrowllow.dto.MessageDto;
import com.example.rrowllow.dto.article.CommentRequestDto;
import com.example.rrowllow.dto.article.CommentResponseDto;
import com.example.rrowllow.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/list")
    public ResponseEntity<List<CommentResponseDto>> getComments(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(commentService.getComment(id));
    }

    @PostMapping("/")
    public ResponseEntity<CommentResponseDto> postComment(@RequestBody CommentRequestDto request) {
        return ResponseEntity.ok(commentService.createComment(request.getArticleId(), request.getBody()));
    }

    @DeleteMapping("/one")
    public ResponseEntity<MessageDto> deleteComment(@RequestParam(name = "id") Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok(new MessageDto("Success"));
    }
}
