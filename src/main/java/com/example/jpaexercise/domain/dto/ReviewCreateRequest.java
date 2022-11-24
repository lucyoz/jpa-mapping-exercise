package com.example.jpaexercise.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateRequest {
    private String title;
    private String content;
    private Integer hospitalId;
    private String userName;
}
