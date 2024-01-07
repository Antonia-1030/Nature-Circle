package com.myProject.Nature_Circle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myProject.Nature_Circle.models.Cart;

public interface CartRepo extends JpaRepository<Cart, Long> {
}
