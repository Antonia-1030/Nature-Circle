package com.myProject.Nature_Circle.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.myProject.Nature_Circle.repo.CathegoryRepo;
import com.myProject.Nature_Circle.repo.UserRepo;
import com.myProject.Nature_Circle.repo.ProductRepo;
import com.myProject.Nature_Circle.repo.OrderRepo;
import com.myProject.Nature_Circle.models.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;


@Component
public class DataGenerator {
    @Autowired
    private CathegoryRepo cathegoryRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepo productRepo;

    @PostConstruct
    public void initCategories() {
        if (cathegoryRepo.count() == 0) {
            Cathegory cathegory = new Cathegory();
            cathegory.setName("Bracelets");
            cathegory.setVatPercent(12);
            Product prod1 = createProduct(cathegory,
                    10,
                    "Big Walnut bracelet",
                    100);
            cathegory.addProduct(prod1);
            cathegory.addProduct(createProduct(cathegory,
                    45.59,
                    "Panda plush",
                    50));
            cathegoryRepo.save(cathegory);
            productRepo.saveAll(cathegory.getProducts());

            Cathegory category2 = new Cathegory();
            category2.setName("Trees");
            category2.setVatPercent(21);
            cathegoryRepo.save(category2);
        }

        if(userRepo.count()==0){
            User user = new User();
            user.setName("Anna");
            user.setEmail("anna@test.com");
            user.setAddress("Kardjali");
            user.setPassword("password");
            user.setPhone("+036161836");
            userRepo.save(user);
        }

        if(orderRepo.count()==0){
            Order order = new Order();
            OrderProduct orderProduct1= new OrderProduct();
            orderProduct1.setProduct(productRepo.findAll().get(0));
            orderProduct1.setVat(20);
            orderProduct1.setPriceNotVat(BigDecimal.valueOf(200.20));
            orderProduct1.setCreatedAt(LocalDateTime.now());
            orderProduct1.setOrder(order);
            order.setNumber("Order1");
            order.setOwner(userRepo.findAll().get(0));
            order.setOrderProducts(Arrays.asList(orderProduct1));
            order.setStatus(OrderStatus.OPEN);
            order.setCreatedAt(LocalDateTime.now());
            orderRepo.save(order);
        }
    }

    private Product createProduct(Cathegory cathegory, double price, String name, int quantity) {
        Product product = new Product();
        product.setPrice(price);
        product.setName(name);
        product.setQuantity(quantity);
        product.setCathegory(cathegory);
        return product;
    }
}
