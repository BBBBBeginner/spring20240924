package com.example.spring20240924.api;

import com.example.spring20240924.dto.a6.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {
    private final CustomerMapper mapper;

    public Customer getCustomer(Integer customerId) {
        return mapper.selectById(customerId);
    }
}