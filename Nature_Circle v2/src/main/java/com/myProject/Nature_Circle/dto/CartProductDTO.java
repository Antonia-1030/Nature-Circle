package com.myProject.Nature_Circle.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartProductDTO extends BaseDTO {
    private long cartId;
    private long productId;
    private int quantity;
}