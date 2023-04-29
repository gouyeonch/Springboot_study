package com.example.myfisrtproject.controller;

import com.example.myfisrtproject.Repository.ArticleRepository;
import com.example.myfisrtproject.dto.ArticleForm;
import com.example.myfisrtproject.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("articles/create")
    public  String createArticle(ArticleForm form) {
        System.out.println(form.toString());

        // 1. dto entity로 변환해야 한다
        Article article = form.toEntity();
        System.out.println(article.toString());

        // 2. 레포지토리를 통해 엔티티를 디비안에 저장하게함
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "";
    }
}
