package com.myProject.Nature_Circle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.myProject.Nature_Circle.models.Product;
import com.myProject.Nature_Circle.repo.ProductRepo;


@Service
public class ProductService extends BaseService<Product>{
    @Autowired
    private ProductRepo productRepo;
    @Override
    protected JpaRepository<Product, Long> getRepo() {
        return productRepo;
    }
}
