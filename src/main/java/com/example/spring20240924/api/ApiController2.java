package com.example.spring20240924.api;

import com.example.spring20240924.dto.a2.Book;
import com.example.spring20240924.dto.a2.Person;

import com.example.spring20240924.dto.a2.Player;
import com.example.spring20240924.dto.a2.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/main2")
public class ApiController2 {
    @PostMapping("sub7")
    public void sub7(@RequestBody List<Book> book) {
        System.out.println(book);
    }

    @PostMapping("sub6")
    public void method6(@RequestBody List<Person> people) {
        System.out.println(people);
    }

    @PostMapping("sub5")
    public void method5(@RequestBody List<String> items) {
        System.out.println(items);
    }

    @PostMapping("sub4")
    public void method4(@RequestBody Product product) {
        System.out.println(product);
    }

    @PostMapping("sub3")
    public void method3(@RequestBody Player player) {
        System.out.println(player);

    }

    @PostMapping("sub2")
    public void method2(@RequestBody Book book) {
        System.out.println(book);

    }

    @PostMapping("sub1")
    public void method1(@RequestBody Person person) {
        System.out.println(person);
    }


}