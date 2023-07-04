package com.example.rrowllow.repository;

import com.example.rrowllow.entity.Article;
import com.example.rrowllow.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendRespository extends JpaRepository<Recommend, Long> {
    List<Recommend> findAllbyArticle(Article article);
}
