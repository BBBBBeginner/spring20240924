package com.example.spring20240924.api;

import com.example.spring20240924.dto.a6.Customer;
import com.example.spring20240924.dto.a6.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class Service6 {
    private final Mapper6 mapper;


    public Customer getCustomer(Integer customerId) {
        return mapper.selectCustomerById(customerId);
    }

    public Supplier getSupplier(Integer supplierId) {

        return mapper.selectSupplierById(supplierId);
    }
}