package com.myProject.Nature_Circle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myProject.Nature_Circle.models.Comment;

public interface CommentRepo extends JpaRepository<Comment,Long> {
}