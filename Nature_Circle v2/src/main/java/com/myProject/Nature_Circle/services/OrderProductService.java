package com.myProject.Nature_Circle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.myProject.Nature_Circle.models.OrderProduct;
import com.myProject.Nature_Circle.repo.OrderProductRepo;

@Service
public class OrderProductService extends BaseService<OrderProduct>{
    @Autowired
    private OrderProductRepo orderProductRepo;
    @Override
    protected JpaRepository<OrderProduct, Long> getRepo() {
        return orderProductRepo;
    }
}