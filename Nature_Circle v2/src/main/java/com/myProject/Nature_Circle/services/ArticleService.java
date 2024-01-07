package com.myProject.Nature_Circle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.myProject.Nature_Circle.models.Article;
import com.myProject.Nature_Circle.repo.ArticleRepo;

@Service
public class ArticleService extends BaseService<Article> {
    @Autowired
    private ArticleRepo articleRepo;

    @Override
    protected JpaRepository<Article, Long> getRepo() {
        return articleRepo;
    }
}