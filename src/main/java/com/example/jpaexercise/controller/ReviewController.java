package com.example.jpaexercise.controller;

import com.example.jpaexercise.domain.Review;
import com.example.jpaexercise.domain.dto.ReviewReadResponse;
import com.example.jpaexercise.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
@Slf4j
@RequiredArgsConstructor        //필요한 argument를 넣어줌. ex: final로 선언한 ReviewService
public class ReviewController {

    private final ReviewService reviewService;

    //1개 조회 기능
    @GetMapping("/{id}")
    public ResponseEntity<Review> get(@PathVariable Long id){
        Review review = reviewService.getReview(id);
        ReviewReadResponse response = ReviewReadResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .userName(review.getUserName())
                .hospitalName(review.getHospital().getHospitalName())
                .build();
        return ResponseEntity.ok().body(review);
    }

}
