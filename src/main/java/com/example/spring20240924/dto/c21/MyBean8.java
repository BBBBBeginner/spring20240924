package com.example.spring20240924.dto.c21;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class MyBean8 {
    private String userName;
    private Integer age;
    private Double score;
    private List<String> foodList;
    private LocalDate startDate;
    private LocalDateTime endDateTime;
    private Boolean expired;

}