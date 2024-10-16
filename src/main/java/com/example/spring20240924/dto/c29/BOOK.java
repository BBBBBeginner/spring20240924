package com.example.spring20240924.dto.c29;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BOOK {
    private String title;
    private String author;
    private LocalDate published;
    private String isbn;
    private Double price;
}
