package com.example.spring20240924.Control;


import com.example.spring20240924.dto.c34.Customer;
import com.example.spring20240924.dto.c34.Orders;
import com.example.spring20240924.dto.c34.Product;
import com.example.spring20240924.dto.c34.Supplier;
import com.example.spring20240924.mapper.Mapper04;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main34")
@RequiredArgsConstructor
public class Controller34 {

    final Mapper04 mapper04;

    @GetMapping("sub1")
    public void sub1() {
        String name = mapper04.getProductName();

    }

    @GetMapping("sub2")
    public void sub2() {
        String s = mapper04.select2();
        Double s1 = mapper04.select3();

        System.out.println("s =" + s);
        System.out.println("s1 =" + s1);


        //1번 직월 의 Lastname 조회
        String s5 = mapper04.select5();
        System.out.println("s5 =" + s5);

    }

    @GetMapping("sub3")
    public void sub3() {
        List<String> list1 = mapper04.select8();
        list1.forEach(System.out::println);

        List<String> list2 = mapper04.select9();
        list2.forEach(System.out::println);


        // 모든 직월의 BirthDate를 조회해서 출력
        // select10

        // 가장 비싼 상품의 가격들 5개만 조회해서 출력
        // select11
        List<Double> doubles = mapper04.select11();
        doubles.forEach(System.out::println);
    }

    // 직원의 LastName을 조회해서 출력
    // select9
    @GetMapping("sub4")
    public void sub4() {
        Map<String, String> result1 = mapper04.select12();
        System.out.println(result1);


        Map<String, String> result2 = mapper04.select13();
        System.out.println(result2);

        Map<String, Object> result3 = mapper04.select14();
        System.out.println(result3);


        // select15
        // 1번 직원의 이름, 생일 조회, 주소, 우편번호 조회
        Map<String, Object> result4 = mapper04.select15();
        System.out.println(result4);
    }

    @GetMapping("sub5")
    public void sub5() {
        // 1행 여러열
        Customer c = mapper04.select17();
        System.out.println("c =" + c);

        Product p = mapper04.select18();
        System.out.println("p =" + p);


        // 10248번 주문의 주문일, 고객명 조회
        // select21 , dto
        Orders order = mapper04.select19();
        System.out.println("order =" + order);
    }

    @GetMapping("sub6")
    public void sub6() {
        //1행 여러열 -> Map
        //1행 여러열 -> DTO

        // 여러행 여러열 -> List<Map>
        // 여러행 여러열 -> List<Dto>


        // 여러행 여러열 -> List<Map>
        List<Map<String, String>> r1 = mapper04.select22();
        r1.forEach(System.out::println);


        // 가장 비싼 상품 5개의 상품명, 카테고리명, 단위, 가격 조회/
        // select23
        List<Map<String, Object>> r2 = mapper04.select23();
        r2.forEach(System.out::println);


    }

    @GetMapping("sub7")
    public void sub7() {

        // USA에 있는 공급자의 id, 이름, 전화번호 조회/출력
        // select26, Supplier
        List<Supplier> s1 = mapper04.select26();
        s1.forEach(System.out::println);


        List<Map<String, String>> s2 = mapper04.select27();
        s2.forEach(System.out::println);


        // 가장 비싼 상품 5개의 상품명, 카테고리명, 단위, 가격 조회/
        // select27, Order
        List<Orders> o1 = mapper04.select28();
        o1.forEach(System.out::println);
    }
}
