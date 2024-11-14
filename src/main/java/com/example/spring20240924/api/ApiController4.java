package com.example.spring20240924.api;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/main4")
public class ApiController4 {
    @GetMapping("sub3/{address}")
    public void method3(@PathVariable String address) {
        System.out.println("address = " + address);
    }

    @GetMapping("sub1/{name}")
    public void sub1(@PathVariable String name) {
        System.out.println("name :" + name);
    }

    @GetMapping("sub2/{quantity}")
    public void sub2(@PathVariable Integer quantity) {
        System.out.println("quantity: " + quantity);
    }
}
