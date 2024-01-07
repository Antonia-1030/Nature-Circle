package com.myProject.Nature_Circle.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.myProject.Nature_Circle.dto.CathegoryDTO;
import com.myProject.Nature_Circle.models.Cathegory;
import com.myProject.Nature_Circle.services.CathegoryService;
import org.modelmapper.ModelMapper;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/cathegory")
public class CathegoryRestController {
    private final CathegoryService cathegoryService;
    private final ModelMapper modelMapper;

    @Autowired
    private CathegoryRestController(CathegoryService cathegoryService, ModelMapper modelMapper) {
        this.cathegoryService = cathegoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<CathegoryDTO> list() {
        List<Cathegory> cathegories = cathegoryService.findAll();
        return cathegories
                .stream()
                .map(this::convertToCategoryDTO)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{categoryId}")
    public CathegoryDTO getCathegory(@PathVariable(name = "categoryId") long cathegoryId) {
        Optional<Cathegory> optionalCathegory = cathegoryService.getEntity(cathegoryId);

        return optionalCathegory.map(this::convertToCategoryDTO).orElse(null);
    }

    private CathegoryDTO convertToCategoryDTO(Cathegory cathegory) {
        final CathegoryDTO result = modelMapper.map(cathegory, CathegoryDTO.class);
        return result;
    }
    @PostMapping()
    public CathegoryDTO create(@RequestBody CathegoryDTO newCategory) {
        Cathegory cathegory = convertCategoryDtoToModel(newCategory);
        return convertToCategoryDTO(cathegoryService.create(cathegory));
    }

    private Cathegory convertCategoryDtoToModel(CathegoryDTO newCategory) {
        Cathegory cathegory = modelMapper.map(newCategory, Cathegory.class);
        return cathegory;
    }

    @PutMapping()
    public CathegoryDTO update(@RequestBody CathegoryDTO newCathegory) {
        Cathegory cathegory = convertCategoryDtoToModel(newCathegory);
        return convertToCategoryDTO(cathegoryService.update(cathegory));
    }

    @DeleteMapping(path = "/{categoryId}")
    public ResponseEntity<String> remove(@PathVariable(name = "categoryId") long cathegoryId) {

        boolean isRemoved = cathegoryService.remove(cathegoryId);

        String deletedMessage = "Cathegory with id: '" + cathegoryId + "' was deleted!";
        String notDeletedMessage = "Cathegory with id: '" + cathegoryId + "' does not exists!";
        return isRemoved ?
                new ResponseEntity(deletedMessage, HttpStatusCode.valueOf(200)):
                new ResponseEntity(notDeletedMessage, HttpStatusCode.valueOf(404));
    }
}
