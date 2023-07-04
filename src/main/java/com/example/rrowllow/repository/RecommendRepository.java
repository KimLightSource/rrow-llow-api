package com.example.rrowllow.repository;

import com.example.rrowllow.entity.Article;
import com.example.rrowllow.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendRepository extends JpaRepository<Recommend, Long> {
    List<Recommend> findAllByArticle(Article article);
}
