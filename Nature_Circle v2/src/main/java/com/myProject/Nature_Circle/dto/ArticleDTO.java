package com.myProject.Nature_Circle.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDTO extends BaseDTO {
    private String content;
    private String title;
    private long ownerId;
}