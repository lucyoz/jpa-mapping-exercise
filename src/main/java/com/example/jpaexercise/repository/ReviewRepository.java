package com.example.jpaexercise.repository;

import com.example.jpaexercise.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
