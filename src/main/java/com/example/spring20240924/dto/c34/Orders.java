package com.example.spring20240924.dto.c34;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Orders {
    private Integer orderId;
    private LocalDate OrderDate;
    private String customerName;


}
