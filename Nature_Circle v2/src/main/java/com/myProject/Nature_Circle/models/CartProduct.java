package com.myProject.Nature_Circle.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CART_PRODUCTS")
public class CartProduct extends MainModel{
    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int quantity;
}
