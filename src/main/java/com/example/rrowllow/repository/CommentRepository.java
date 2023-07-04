package com.example.rrowllow.repository;

import com.example.rrowllow.entity.Article;
import com.example.rrowllow.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByArticle(Article article);
}
