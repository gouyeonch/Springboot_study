package com.example.myfisrtproject.controller;

import com.example.myfisrtproject.Repository.ArticleRepository;
import com.example.myfisrtproject.dto.ArticleForm;
import com.example.myfisrtproject.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {

    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("articles/create")
    public  String createArticle(ArticleForm form) {
        //
        //System.out.println(form.toString()); -> 로깅 기능으로 대체
        log.info(form.toString());

        // 1. dto entity로 변환해야 한다
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());

        // 2. 레포지토리를 통해 엔티티를 디비안에 저장하게함
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString());

        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        //id로 데이터를 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);

        //가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        //보여줄 페이지를 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        // 모든 아티클 가져오기
        List<Article> articleEntityList = (List<Article>) articleRepository.findAll();

        // 가져온 아티클 묶음을 뷰로 전달
        model.addAttribute("articleList", articleEntityList);

        // 뷰 페이지를 설정
        return "articles/index";
    }
}
