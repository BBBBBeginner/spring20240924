package com.example.spring20240924.api;

import com.example.spring20240924.dto.a6.Customer;
import com.example.spring20240924.dto.a6.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/main6")
@RequiredArgsConstructor
public class ApiController6 {
    private final CustomerService service;

//    @GetMapping("sub2/{supplierId}")
//    public Supplier getSupplier(@PathVariable Integer supplierId) {
//        return service.getSupplier(supplierId);
//    }

    @GetMapping("sub1/{customerId}")
    @ResponseBody
    public Customer get(@PathVariable Integer customerId) {
        return service.getCustomer(customerId);
    }
}