package com.example.spring20240924.dto.c15;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private Integer price;
}
