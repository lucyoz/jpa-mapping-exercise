package com.example.jpaexercise.service;

import com.example.jpaexercise.domain.Hospital;
import com.example.jpaexercise.domain.Review;
import com.example.jpaexercise.domain.dto.HospitalResponse;
import com.example.jpaexercise.repository.HospitalRepository;
import com.example.jpaexercise.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public HospitalService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

//    public HospitalResponse findById(Integer id){
//        Optional<Hospital> optHospital = hospitalRepository.findById(id);
//        Hospital hospital = optHospital.get();
//        HospitalResponse hospitalResponse = Hospital.of(hospital);
//    }


}
