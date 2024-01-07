package com.myProject.Nature_Circle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myProject.Nature_Circle.models.Article;

public interface ArticleRepo extends JpaRepository<Article, Long> {
}