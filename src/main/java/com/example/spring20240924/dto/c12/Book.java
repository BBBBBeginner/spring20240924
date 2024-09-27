package com.example.spring20240924.dto.c12;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Book {
    private String title;
    private String author;
    private Integer price;

}
