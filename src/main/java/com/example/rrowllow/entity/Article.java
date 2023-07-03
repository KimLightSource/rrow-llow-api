package com.example.rrowllow.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Article extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "article")
    private List<Recommend> recommends = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public static Article createArticle(String title, String body, Member member) {
        Article article = new Article();
        article.title = title;
        article.body = body;
        article.member = member;

        return article;
    }

    public static Article changeArticle(Article article, String title, String body) {
        article.title = title;
        article.body = body;

        return article;
    }

}
