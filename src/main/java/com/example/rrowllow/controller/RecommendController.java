package com.example.rrowllow.controller;

import com.example.rrowllow.dto.MessageDto;
import com.example.rrowllow.dto.article.PostRecommendDto;
import com.example.rrowllow.dto.article.RecommendDto;
import com.example.rrowllow.service.RecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recommend")
public class RecommendController {
    private final RecommendService recommendService;

    @GetMapping("/list")
    public ResponseEntity<RecommendDto> getRecommends(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(recommendService.allRecommend(id));
    }

    @PostMapping("/")
    public ResponseEntity<MessageDto> postRecommend(@RequestBody PostRecommendDto dto) {
        recommendService.createRecommend(dto.getId());
        return ResponseEntity.ok(new MessageDto("success"));
    }

    @DeleteMapping("/one")
    public ResponseEntity<MessageDto> deleteRecommend(@RequestParam(name = "id") Long id) {
        recommendService.deleteRecommend(id);
        return ResponseEntity.ok(new MessageDto("success"));
    }
}
