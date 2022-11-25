package com.example.jpaexercise.service;

import com.example.jpaexercise.domain.Hospital;
import com.example.jpaexercise.domain.Review;
import com.example.jpaexercise.domain.dto.HospitalResponse;
import com.example.jpaexercise.repository.HospitalRepository;
import com.example.jpaexercise.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;


    public Hospital findById(Integer id) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 id가 없습니다."));
        return hospital;
    }
}
