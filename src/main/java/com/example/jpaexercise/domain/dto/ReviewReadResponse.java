package com.example.jpaexercise.domain.dto;

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
}
