package com.myProject.Nature_Circle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myProject.Nature_Circle.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}