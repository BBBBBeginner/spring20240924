package com.example.spring20240924.dto.c38;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer {
    private Integer id;
    private String name;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;

}