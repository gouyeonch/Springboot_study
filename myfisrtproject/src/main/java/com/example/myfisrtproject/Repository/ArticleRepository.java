package com.example.myfisrtproject.Repository;

import com.example.myfisrtproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
