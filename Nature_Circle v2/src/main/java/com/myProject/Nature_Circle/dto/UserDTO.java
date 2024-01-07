package com.myProject.Nature_Circle.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import com.myProject.Nature_Circle.models.User;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends BaseDTO{

    private String name;
    private String password;
    private String email;
    private boolean isActive = true;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoggedAt;
    private String phone;
    private String address;
}
