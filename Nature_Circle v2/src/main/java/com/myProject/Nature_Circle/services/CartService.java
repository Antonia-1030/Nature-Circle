package com.myProject.Nature_Circle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.myProject.Nature_Circle.models.Cart;
import com.myProject.Nature_Circle.repo.CartRepo;

@Service
public class CartService extends BaseService<Cart> {
    @Autowired
    private CartRepo cartRepo;

    @Override
    protected JpaRepository<Cart, Long> getRepo() {
        return cartRepo;
    }
}