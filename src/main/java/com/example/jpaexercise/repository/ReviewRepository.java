package com.example.jpaexercise.repository;

import com.example.jpaexercise.domain.Hospital;
import com.example.jpaexercise.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByHospital(Hospital hospital);
}
