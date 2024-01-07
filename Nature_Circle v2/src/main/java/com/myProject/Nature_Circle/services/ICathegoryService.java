package com.myProject.Nature_Circle.services;

import com.myProject.Nature_Circle.dto.CathegoryDTO;

import java.util.List;

public interface ICathegoryService {
    List<CathegoryDTO> getAll();
    CathegoryDTO getBy(Long id);

    CathegoryDTO create(CathegoryDTO categoryDTO);

    CathegoryDTO update(CathegoryDTO categoryDTO);

    boolean remove(long id);

}
