package com.myProject.Nature_Circle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myProject.Nature_Circle.models.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
}