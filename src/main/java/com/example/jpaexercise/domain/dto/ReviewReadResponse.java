package com.example.jpaexercise.domain.dto;

import com.example.jpaexercise.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ReviewReadResponse {
    private Long id;
    private String title;
    private String content;
    private String hospitalName;
    private String userName;

    public static ReviewReadResponse fromEntity(Review review){
        ReviewReadResponse response = ReviewReadResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .userName(review.getUserName())
                .hospitalName(review.getHospital().getHospitalName())
                .build();

        return response;
    }
}
