package com.example.spring20240924.Control;


import com.example.spring20240924.dto.c11.Car;
import com.example.spring20240924.dto.c11.Person;
import com.example.spring20240924.dto.c11.Player;
import com.example.spring20240924.dto.c11.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main11")

public class Controller11 {


    //list 안에 map
    @RequestMapping("sub1")
    public String sub1(Model model) {
        //String , 기본타입, 배열, List, Map, JavaBeans
        var data = List.of(
                Map.of("name", "흥민",
                        "team", "토트넘"),

                Map.of("price", "600",
                        "model", "truck"),

                Map.of(
                        "contry", "korea",
                        "location", "한강")
        );

        model.addAttribute("data", data);
        return null;
    }


    @RequestMapping("sub2")
    public void sub2(Model model) {
        model.addAttribute("list1", List.of(
                Map.of("team", "자이언츠",
                        "price", 10000,
                        "number", 4567
                ),
                Map.of("locateion", "korea",
                        "name", "jun"),
                Map.of("company", "ibm")
        ));
    }


    //map안에 list
    @RequestMapping("sub3")
    public String sub3(Model model) {

        model.addAttribute("data", Map.of(
                "list1", List.of("tesla", "volvo", "kia"),
                "languages", List.of("java", "js", "c++", "python")
        ));
        return null;
    }


    @RequestMapping("sub4")
    public void sub4(Model model) {
        model.addAttribute("car",
                Map.of(
                        "hyundai", List.of("tesla", "volvo", "kia")
                ));
        model.addAttribute("student",
                Map.of(
                        "son", List.of("tesla", "volvo", "kia")
                ));
    }


    @RequestMapping("sub5")
    public String sub5(Model model) {
        // List 내의 JavaBeans
        List<Student> students = List.of(
                new Student(1, "son", 33, 98.1234, "gmail"),
                new Student(5, "hong", 55, 77.33, "yahoo"),
                new Student(7, "messi", 66, 88.44, "daum"),
                new Student(10, "otani", 22, 66.11, "naver"));

        model.addAttribute("students", students);
        return null;

    }

    @RequestMapping("sub6")
    public String sub6(Model model) {
        model.addAttribute("carList", List.of(
                new Car("model x", 5000, false),
                new Car("model s", 4000, true),
                new Car("truck", 3000, false)
        ));
        return null;
    }


    @RequestMapping("sub7")
    public String sub7(Model model) {
        // JavaBeans 내의 List
        model.addAttribute("person",
                new Person("donald", "trump", 77, List.of("game", "soccer", "golf")));

        return null;
    }

    @RequestMapping("sub8")
    public String sub8(Model model) {
        model.addAttribute("player",
                new Player("donald", "trump", "yahoo", true,
                        List.of("토트넘", "맨시티", "다저스"),
                        List.of(3.14, 5.12, 6.34, 7.56)));
        return null;

    }
}
