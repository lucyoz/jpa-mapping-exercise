package com.example.jpaexercise.domain.dto;

import com.example.jpaexercise.domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class HospitalReadResponse {
    private Integer id;
    private String hospitalName;
    private String roadNameAddress;
    private List<ReviewReadResponse> reviews;

    public static HospitalReadResponse fromEntity(Hospital hospital){
        return HospitalReadResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .reviews(hospital.getReviews().stream()
                        .map(review -> ReviewReadResponse.fromEntity(review)).collect(Collectors.toList())) //review를 ReviewReadResponse로
                .build();
    }
}
