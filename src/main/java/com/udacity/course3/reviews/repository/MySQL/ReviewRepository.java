package com.udacity.course3.reviews.repository.MySQL;

import com.udacity.course3.reviews.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	@Query("SELECT r FROM Review r WHERE r.product.productId = :productId")
	List<Review> findAllByProductId(Integer productId);
}