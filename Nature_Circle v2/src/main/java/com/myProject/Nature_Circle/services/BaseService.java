package com.myProject.Nature_Circle.services;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myProject.Nature_Circle.dto.BaseDTO;
import com.myProject.Nature_Circle.models.MainModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

public abstract class BaseService<U extends MainModel> {
    protected abstract JpaRepository<U, Long> getRepo();

    public List<U> findAll() {
        return getRepo().findAll();
    }

    public Optional<U> getEntity(Long id){
        return getRepo().findById(id);
    }

    public U create(U entity) {
        entity.setCreatedAt(LocalDateTime.now());
        return getRepo().save(entity);
    }

    public U update(U entity) {
        long id = entity.getId();
        Optional<U> optionalEntity = getRepo().findById(id);
        if (optionalEntity.isPresent()) {
            entity.setUpdatedAt(LocalDateTime.now());
            return getRepo().save(entity);
        }
        return null;
    }

    public boolean remove(long id) {
        Optional<U> optionalCathegory = getRepo().findById(id);
        if (optionalCathegory.isPresent()) {
            getRepo().delete(optionalCathegory.get());
            return true;
        }
        return false;
    }
}
