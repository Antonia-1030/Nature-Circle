package com.myProject.Nature_Circle.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Product_Cathegory")
public class Cathegory extends MainModel{
        @Column(nullable = false, unique = true)
        private String name;
        @Column(name = "vat_percent", nullable = false)
        private int vatPercent;
        @Transient
        private String temp;
        @OneToMany(mappedBy = "category")
        private Set<Product> products;

        @ManyToOne(optional = true)
        @JoinColumn(name = "parent_id")
        private Cathegory parent;

        @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
        private List<Cathegory> children;

        public boolean addProduct(final Product product){
                if(products ==null){
                        products = new HashSet<>();
                }
                return products.add(product);
        }
}

