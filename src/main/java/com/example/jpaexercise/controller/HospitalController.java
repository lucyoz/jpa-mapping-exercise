package com.example.jpaexercise.controller;

import com.example.jpaexercise.domain.Hospital;
import com.example.jpaexercise.domain.dto.*;
import com.example.jpaexercise.service.HospitalService;
import com.example.jpaexercise.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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
    public ResponseEntity<ReviewCreateResponse> add(@PathVariable Integer id, @RequestBody ReviewCreateRequest reviewCreateRequest){
        return ResponseEntity.ok().body(reviewService.createReview(reviewCreateRequest));

    }


    @GetMapping("/{hospitalId}/reviews")
    public ResponseEntity<List<ReviewReadResponse>> reviews(@PathVariable Integer hospitalId){
        return ResponseEntity.ok().body(reviewService.findAllByHospitalId(hospitalId));

    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalReadResponse> hospital(@PathVariable Integer id){
        Hospital hospital = hospitalService.findById(id);
        // DTO로 매핑하는 로직

        HospitalReadResponse response = HospitalReadResponse.fromEntity(hospital);
        return ResponseEntity.ok().body(response);


    }

}
