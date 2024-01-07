package com.myProject.Nature_Circle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.myProject.Nature_Circle.dto.BaseDTO;
import com.myProject.Nature_Circle.dto.RatingDTO;
import com.myProject.Nature_Circle.models.Product;
import com.myProject.Nature_Circle.models.Rating;
import com.myProject.Nature_Circle.models.User;
import com.myProject.Nature_Circle.repo.RatingRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RatingService extends BaseService<Rating>{
    @Autowired
    private RatingRepo ratingRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Override
    protected JpaRepository<Rating, Long> getRepo() {
        return ratingRepo;
    }

    public List<Rating> findAllByUserId(long userId) {
        Optional<User> entity = userService.getEntity(userId);

        return ratingRepo.findByUser(entity.orElseThrow());
    }
    public List<Rating> findAllByProductId(long productId) {
        Optional<Product> entity = productService.getEntity(productId);

        return ratingRepo.findByProduct(entity.orElseThrow());
    }

    public List<Rating> findAllByProductIdAndUserId(Long productId, Long userId) {
        Optional<Product> product = productService.getEntity(productId);
        Optional<User> user = userService.getEntity(userId);

        return ratingRepo.findByProductAndUser(product.orElseThrow(), user.orElseThrow());
    }
}
