package com.example.spring20240924.Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main22")
public class Controller22 {
    @GetMapping("sub1")
    public void s1() {
    }
}