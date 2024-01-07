package com.myProject.Nature_Circle.services;

import org.springframework.stereotype.Service;
import com.myProject.Nature_Circle.dto.CathegoryDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import com.myProject.Nature_Circle.models.Cathegory;
import com.myProject.Nature_Circle.repo.CathegoryRepo;
import com.myProject.Nature_Circle.dto.BaseDTO;


@AllArgsConstructor
@Service
public class CathegoryService extends BaseService<Cathegory>{
    CathegoryRepo cathegoryRepo;
    @Override
    protected JpaRepository<Cathegory, Long> getRepo() {
        return cathegoryRepo;
    }
}
