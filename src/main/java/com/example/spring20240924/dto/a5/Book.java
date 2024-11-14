package com.example.spring20240924.dto.a5;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String author;
    private String content;
    private Integer price;
}