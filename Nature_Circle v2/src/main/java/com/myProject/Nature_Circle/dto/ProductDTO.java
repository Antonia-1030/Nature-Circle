package com.myProject.Nature_Circle.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.myProject.Nature_Circle.models.Cathegory;
import com.myProject.Nature_Circle.models.Product;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO extends BaseDTO{

    private String name;
    private double price;
    private String description;
    private int quantity;
    private long categoryId;
}
