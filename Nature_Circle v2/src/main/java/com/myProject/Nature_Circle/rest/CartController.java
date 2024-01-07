package com.myProject.Nature_Circle.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.myProject.Nature_Circle.dto.CartDTO;
import com.myProject.Nature_Circle.models.Cart;
import com.myProject.Nature_Circle.models.User;
import com.myProject.Nature_Circle.services.CartService;
import com.myProject.Nature_Circle.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/car")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<CartDTO> findAll() {
        return cartService.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{cartId}")
    public CartDTO getBy(@PathVariable(name = "cartId") long articleId) {
        return convertToDTO(cartService.getEntity(articleId).get());
    }

    @PostMapping()
    public CartDTO create(@RequestBody CartDTO cartDTO) {
        Cart cart = convertToModel(cartDTO);
        cart.setId(null);
        return convertToDTO(cartService.create(cart));
    }

    @PutMapping()
    public CartDTO update(@RequestBody CartDTO cartDTO) {
        Cart cart = convertToModel(cartDTO);
        return convertToDTO(cartService.update(cart));
    }

    @DeleteMapping(path = "/{cartId}")
    public ResponseEntity<String> remove(@PathVariable(name = "cartId") long cartId) {

        boolean isRemoved = cartService.remove(cartId);

        String deletedMessage = "Cart with id: '" + cartId + "' was deleted!";
        String notDeletedMessage = "Cart with id: '" + cartId + "' does not exists!";
        return isRemoved ?
                new ResponseEntity<>(deletedMessage, HttpStatusCode.valueOf(200)) :
                new ResponseEntity<>(notDeletedMessage, HttpStatusCode.valueOf(404));
    }

    private Cart convertToModel(CartDTO cartDTO) {
        Cart cart = modelMapper.map(cartDTO, Cart.class);
        User owner = userService.getEntity(cartDTO.getOwnerId())
                .orElseThrow(() -> new IllegalStateException("wrong owner id"));
        cart.setUser(owner);
        return cart;
    }

    private CartDTO convertToDTO(Cart cart) {
        CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);
        cartDTO.setOwnerId(cart.getUser().getId());
        return cartDTO;
    }
}