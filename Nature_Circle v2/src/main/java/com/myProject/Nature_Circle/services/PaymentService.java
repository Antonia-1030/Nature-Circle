package com.myProject.Nature_Circle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.myProject.Nature_Circle.models.Payment;
import com.myProject.Nature_Circle.repo.PaymentRepo;

@Service
public class PaymentService extends BaseService<Payment> {
    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    protected JpaRepository<Payment, Long> getRepo() {
        return paymentRepo;
    }
}