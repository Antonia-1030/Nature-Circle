package com.myProject.Nature_Circle.dto;

import lombok.Getter;
import lombok.Setter;
import com.myProject.Nature_Circle.models.OrderStatus;
import com.myProject.Nature_Circle.models.User;

@Getter
@Setter
public class OrderDTO extends BaseDTO {
    private String number;
    private User owner;
    private OrderStatus status;
}