package com.example.jpaexercise.controller;

import com.example.jpaexercise.domain.dto.ReviewCreateRequest;
import com.example.jpaexercise.domain.dto.ReviewCreateResponse;
import com.example.jpaexercise.service.HospitalService;
import com.example.jpaexercise.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {
    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitalController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> get(@PathVariable Integer id, @RequestBody ReviewCreateRequest reviewCreateRequest){
        return ResponseEntity.ok().body(reviewService.addReview(reviewCreateRequest));

    }
}
