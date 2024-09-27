package com.example.spring20240924.dto.c12;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//@AllArgsConstructor // 모든 필드를 받는 생성자
//@NoArgsConstructor // final 필드 받는 생성자
@RequiredArgsConstructor // 아규먼트(파라미터) 없는 생성자


public class Player {

    private final int age;
    private final String name;
    private Boolean married;


}
