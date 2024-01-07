package com.myProject.Nature_Circle.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.myProject.Nature_Circle.dto.ArticleDTO;
import com.myProject.Nature_Circle.models.Article;
import com.myProject.Nature_Circle.models.User;
import com.myProject.Nature_Circle.services.ArticleService;
import com.myProject.Nature_Circle.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<ArticleDTO> findAll() {
        return articleService.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{articleId}")
    public ArticleDTO getBy(@PathVariable(name = "articleId") long articleId) {
        return convertToDTO(articleService.getEntity(articleId).get());
    }

    @PostMapping()
    public ArticleDTO create(@RequestBody ArticleDTO articleDTO) {
        Article article = convertToModel(articleDTO);
        article.setId(null);
        return convertToDTO(articleService.create(article));
    }

    @PutMapping()
    public ArticleDTO update(@RequestBody ArticleDTO articleDTO) {
        Article article = convertToModel(articleDTO);
        return convertToDTO(articleService.update(article));
    }

    @DeleteMapping(path = "/{articleId}")
    public ResponseEntity<String> remove(@PathVariable(name = "articleId") long articleId) {

        boolean isRemoved = articleService.remove(articleId);

        String deletedMessage = "Article with id: '" + articleId + "' was deleted!";
        String notDeletedMessage = "Article with id: '" + articleId + "' does not exists!";
        return isRemoved ?
                new ResponseEntity<>(deletedMessage, HttpStatusCode.valueOf(200)) :
                new ResponseEntity<>(notDeletedMessage, HttpStatusCode.valueOf(404));
    }

    private Article convertToModel(ArticleDTO articleDTO) {
        Article article = modelMapper.map(articleDTO, Article.class);
        User owner = userService.getEntity(articleDTO.getOwnerId())
                .orElseThrow(() -> new IllegalStateException("wrong owner id"));
        article.setOwner(owner);
        return article;
    }

    private ArticleDTO convertToDTO(Article article) {
        ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
        articleDTO.setOwnerId(article.getOwner().getId());
        return articleDTO;
    }
}
