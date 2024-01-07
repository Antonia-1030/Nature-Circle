package com.myProject.Nature_Circle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.myProject.Nature_Circle.models.Order;
import com.myProject.Nature_Circle.repo.OrderRepo;

@Service
public class OrderService extends BaseService<Order> {
    @Autowired
    private OrderRepo orderRepo;

    @Override
    protected JpaRepository<Order, Long> getRepo() {
        return orderRepo;
    }
}