package com.example.spring20240924.dto.a2;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String author;
    private String content;
    private Integer price;
    private Integer quantity;
}
