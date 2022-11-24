package com.example.jpaexercise.service;

import com.example.jpaexercise.domain.Hospital;
import com.example.jpaexercise.domain.Review;
import com.example.jpaexercise.domain.dto.ReviewCreateRequest;
import com.example.jpaexercise.domain.dto.ReviewCreateResponse;
import com.example.jpaexercise.repository.HospitalRepository;
import com.example.jpaexercise.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewCreateResponse addReview(ReviewCreateRequest reviewCreateRequest){
        Optional<Hospital> hospital = hospitalRepository.findById(reviewCreateRequest.getHospitalId());
        Review review = Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .userName(reviewCreateRequest.getUserName())
                .hospital(hospital.get())
                .build();
        Review savedReview = reviewRepository.save(review);
        return new ReviewCreateResponse(savedReview.getId(), savedReview.getTitle(), savedReview.getContent(), savedReview.getUserName(), "리뷰 등록을 성공했습니다.");

    }

}
