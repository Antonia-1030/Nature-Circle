package com.myProject.Nature_Circle.dto;

import com.myProject.Nature_Circle.models.MainModel;
import lombok.NoArgsConstructor;
import com.myProject.Nature_Circle.models.Cathegory;

import java.util.List;
@NoArgsConstructor
public class CathegoryDTO extends BaseDTO {
    private String name;
    private CathegoryDTO parent;
    private List<CathegoryDTO> children;
    private int vatPercent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CathegoryDTO getParent() {
        return parent;
    }

    public void setParent(CathegoryDTO parent) {
        this.parent = parent;
    }

    public List<CathegoryDTO> getChildren() {
        return children;
    }

    public void setChildren(List<CathegoryDTO> children) {
        this.children = children;
    }

    public int getVatPercent() {
        return vatPercent;
    }

    public void setVatPercent(int vatPercent) {
        this.vatPercent = vatPercent;
    }
}
