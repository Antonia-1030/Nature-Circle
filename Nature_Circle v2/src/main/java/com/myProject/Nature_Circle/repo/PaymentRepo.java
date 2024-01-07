package com.myProject.Nature_Circle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myProject.Nature_Circle.models.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
}