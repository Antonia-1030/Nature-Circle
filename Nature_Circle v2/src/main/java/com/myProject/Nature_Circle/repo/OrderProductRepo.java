package com.myProject.Nature_Circle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myProject.Nature_Circle.models.OrderProduct;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {
}