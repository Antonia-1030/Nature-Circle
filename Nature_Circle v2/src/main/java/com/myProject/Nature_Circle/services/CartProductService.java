package com.myProject.Nature_Circle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.myProject.Nature_Circle.models.CartProduct;
import com.myProject.Nature_Circle.repo.CartProductRepo;

@Service
public class CartProductService extends BaseService<CartProduct> {
    @Autowired
    private CartProductRepo cartProductRepo;

    @Override
    protected JpaRepository<CartProduct, Long> getRepo() {
        return cartProductRepo;
    }
}