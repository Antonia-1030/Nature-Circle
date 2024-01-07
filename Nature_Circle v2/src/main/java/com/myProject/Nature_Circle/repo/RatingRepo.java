package com.myProject.Nature_Circle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myProject.Nature_Circle.models.Product;
import com.myProject.Nature_Circle.models.Rating;
import com.myProject.Nature_Circle.models.User;

import java.util.List;
import java.util.Collection;

public interface RatingRepo extends JpaRepository<Rating,Long>{
    List<Rating> findByUser(final User owner);
    List<Rating> findByProduct(final Product relatedProduct);
    List<Rating> findByProductAndUser(Product product, User user);
}
