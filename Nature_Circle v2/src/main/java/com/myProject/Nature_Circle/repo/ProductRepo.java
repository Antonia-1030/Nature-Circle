package com.myProject.Nature_Circle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myProject.Nature_Circle.models.Product;

public interface ProductRepo extends JpaRepository<Product,Long> {
}