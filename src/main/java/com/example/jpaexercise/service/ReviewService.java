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

    public ReviewCreateResponse createReview(ReviewCreateRequest reviewCreateRequest){
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

    public Review getReview(Long id) {
        //Optional<Review> review = reviewRepository.findById(id);

        //Optional과 .orElseThrow()
        //Optional을 쓰는 이유? null을 쓰지 않으려고, DB조회 시 findById()를 쓸 때 안 나올 수도 있다.
        //Optional을 썼을 때 .orElseThrow()나 .orElse()등을 써서 코드를 짧게 쓸 수 있다.

        Review review = reviewRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 id가 없습니다."));
        return review;
    }



}
