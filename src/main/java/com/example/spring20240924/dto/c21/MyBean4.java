package com.example.spring20240924.dto.c21;


import lombok.Data;

import java.time.LocalDate;

@Data
public class MyBean4 {
    private String address;
    private Integer age;
    private LocalDate birth;
}