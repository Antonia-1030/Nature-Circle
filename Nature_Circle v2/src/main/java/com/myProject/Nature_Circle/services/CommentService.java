package com.myProject.Nature_Circle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.myProject.Nature_Circle.models.Comment;
import com.myProject.Nature_Circle.repo.CommentRepo;

@Service
public class CommentService extends BaseService<Comment> {
    @Autowired
    private CommentRepo commentRepo;

    @Override
    protected JpaRepository<Comment, Long> getRepo() {
        return commentRepo;
    }
}