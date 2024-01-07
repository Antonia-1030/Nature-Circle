package com.myProject.Nature_Circle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.myProject.Nature_Circle.dto.BaseDTO;
import com.myProject.Nature_Circle.dto.UserDTO;
import com.myProject.Nature_Circle.models.User;
import com.myProject.Nature_Circle.repo.UserRepo;

import java.time.LocalDateTime;

@Service
public class UserService extends BaseService<User> {
    @Autowired
    UserRepo userRepo;

    @Override
    protected JpaRepository<User, Long> getRepo() {
        return userRepo;
    }
}
