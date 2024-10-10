package com.example.spring20240924.dto.c27;

import lombok.Data;

@Data
public class Order {
    private String id;
    private String customerId;
    private String employeeId;
    private String orderDate;
    private String shipperId;
}