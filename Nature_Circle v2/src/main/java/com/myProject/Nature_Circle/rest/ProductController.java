package com.myProject.Nature_Circle.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.myProject.Nature_Circle.dto.ProductDTO;
import com.myProject.Nature_Circle.models.Product;
import com.myProject.Nature_Circle.services.ProductService;
import com.myProject.Nature_Circle.models.Cathegory;
import com.myProject.Nature_Circle.services.CathegoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CathegoryService cathegoryService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ProductDTO> findAll() {
        List<Product> products = productService.findAll();
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO convertToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    @GetMapping(path = "/{productId}")
    public ProductDTO getBy(@PathVariable(name = "productId") long productId) {
        Optional<Product> optionalProduct = productService.getEntity(productId);
        return optionalProduct.map(this::convertToDTO).orElse(null);
    }

    @PostMapping()
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        Product product = convertToModel(productDTO);
        product.setId(null);
        return convertToDTO(productService.create(product));
    }

    private Product convertToModel(ProductDTO productDTO){
        Product product = modelMapper.map(productDTO, Product.class);
        if(productDTO.getCategoryId()>0){
            Optional<Cathegory> optionalCategory = cathegoryService.getEntity(productDTO.getCategoryId());
            if(optionalCategory.isPresent()){
                product.setCathegory(optionalCategory.get());
            }else {
                throw new IllegalStateException("The category with id: '"+productDTO.getCategoryId()+"' does not exist!");
            }
        }
        return product;
    }

    @PutMapping()
    public ProductDTO update(@RequestBody ProductDTO productDTO) {
        Product updated = productService.update(convertToModel(productDTO));
        return convertToDTO(updated);
    }

    @DeleteMapping(path = "/{productId}")
    public ResponseEntity<String> remove(@PathVariable(name = "productId") long productId) {

        boolean isRemoved = productService.remove(productId);

        String deletedMessage = "Product with id: '" + productId + "' was deleted!";
        String notDeletedMessage = "Product with id: '" + productId + "' does not exists!";
        return isRemoved ?
                new ResponseEntity<>(deletedMessage, HttpStatusCode.valueOf(200)) :
                new ResponseEntity<>(notDeletedMessage, HttpStatusCode.valueOf(404));
    }
}
