package com.myProject.Nature_Circle.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDTO extends BaseDTO {
    private String token;
    private boolean successful;
    private BigDecimal sum;
    private long orderId;
}