package com.myProject.Nature_Circle.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.myProject.Nature_Circle.models.Product;
import com.myProject.Nature_Circle.models.Rating;
import com.myProject.Nature_Circle.models.User;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class RatingDTO extends BaseDTO{

    private int value;
    private String comment;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private long productId;
    private long userId;
}
