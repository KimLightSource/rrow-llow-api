package com.example.rrowllow.service;

import com.example.rrowllow.config.SecurityUtil;
import com.example.rrowllow.dto.article.CommentResponseDto;
import com.example.rrowllow.entity.Article;
import com.example.rrowllow.entity.Comment;
import com.example.rrowllow.entity.Member;
import com.example.rrowllow.repository.ArticleRepository;
import com.example.rrowllow.repository.CommentRepository;
import com.example.rrowllow.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

    public List<CommentResponseDto> getComment(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("글이 없습니다."));
        List<Comment> comments = commentRepository.findAllByArticle(article);
        if (comments.isEmpty()) return Collections.emptyList(); //비어있는 경우 비어있는 리스트를 반환
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal() == "annonymousUser") {
            return comments
                    .stream()
                    .map(comment -> CommentResponseDto.of(comment, false))
                    .collect(Collectors.toList());
        } else {
            Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId())
                                            .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));

            //True 값을 가진(로그인한 유저정보와 일치하는) List<Comment> 와 False 값을 가진(로그인한 유저정보와 일치하지 않는) List<Comment>로 분할
            Map<Boolean, List<Comment>> collect = comments.stream()
                                                          .collect(Collectors.partitioningBy(comment -> comment.getMember().equals(member)));
            //분할한 List를 Dto로 담아주고
            List<CommentResponseDto> trueCollect = collect.get(true).stream()
                                                          .map(t -> CommentResponseDto.of(t, true)).toList();
            List<CommentResponseDto> falseCollect = collect.get(false).stream()
                                                           .map(t -> CommentResponseDto.of(t, true)).toList();
            //CommentId순 으로 정렬해서 반환
            return Stream
                    .concat(trueCollect.stream(), falseCollect.stream())
                    .sorted(Comparator.comparing(CommentResponseDto::getCommentId))
                    .toList();
        }
    }

    @Transactional
    public CommentResponseDto createComment(Long id, String text) {
        Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId())
                                        .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        Article article = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글이 없습니다."));
        Comment comment = Comment.builder()
                                 .member(member)
                                 .text(text)
                                 .article(article).build();
        return CommentResponseDto.of(commentRepository.save(comment), true);
    }

    @Transactional
    public void deleteComment(Long id) {
        Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId()).orElseThrow(() -> new RuntimeException("로그인 하십시오"));
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("댓글이 없습니다."));
        if (!comment.getMember().equals(member)) {throw new RuntimeException("작성자와 로그인이 일치하지 않습니다.");}
        commentRepository.delete(comment);
    }
}
