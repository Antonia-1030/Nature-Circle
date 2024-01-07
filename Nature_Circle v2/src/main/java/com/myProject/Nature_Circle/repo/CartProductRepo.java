package com.myProject.Nature_Circle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myProject.Nature_Circle.models.CartProduct;

public interface CartProductRepo extends JpaRepository<CartProduct, Long>{
}
