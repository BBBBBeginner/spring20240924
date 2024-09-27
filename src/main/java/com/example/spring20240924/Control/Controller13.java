package com.example.spring20240924.Control;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main13")
public class Controller13 {

    @RequestMapping("sub1")
    public void method1(Model model) {
        model.addAttribute("attr1", "hello model attribute");
    }

    @RequestMapping("sub2")
    public void method2(Model model) {
    }

    @RequestMapping("sub3")
    public void method3(Model model) {
    }

    @RequestMapping("sub4")
    public void method4(Model model) {
    }

    @RequestMapping("sub5")
    public void method5(Model model) {

    }

    @RequestMapping("sub6")
    public void method6(Model model) {
        model.addAttribute("products", List.of("콜라", "피자", "소주", "코기", "케밥"));
        model.addAttribute("players", List.of("오타니", "범근", "흥민", "케인", "지성"));
        model.addAttribute("cityList", List.of("seoul", "jeju", "busan", "london", "ny", "la"));
    }

    @RequestMapping("sub7")
    public void method7(Model model) {
        model.addAttribute("people",
                Map.of("kim", "seoul",
                        "lee", "busan",
                        "choi", "jeju",
                        "park", "ulsan"
                ));

        model.addAttribute("players", Map.of(
                "손흥민", "토트넘",
                "케인", "뮌헨",
                "벨링엄", "레알"
        ));

        model.addAttribute("food",
                Map.of(
                        "초콜릿", "가나",
                        "탄산", "코카콜라",
                        "버거", "빅맥",
                        "피자", "하와이안"
                ));
    }

    @RequestMapping("sub8")
    public void method8(Model model) {
        model.addAttribute("datas",
                List.of(Map.of("marvel", "avangers",
                                "sony", "spiderman"),
                        Map.of("show", "오겜",
                                "drama", "무빙",
                                "film", "조커")));

        model.addAttribute("players", List.of(
                Map.of("손흥민", "토트넘",
                        "케인", "뮌헨",
                        "벨링엄", "레알"),
                Map.of("손흥민", "토트넘",
                        "케인", "뮌헨",
                        "벨링엄", "레알")));
    }

    @RequestMapping("sub9")
    public void method9(Model model) {
        model.addAttribute("data",
                Map.of("foods", List.of("피자", "버거", "국밥", "파전"),
                        "coffees", List.of("아메", "라떼", "모카")));

        model.addAttribute("movies",
                Map.of("marvel", List.of("ironman", "captain", "panther"),
                        "dc", List.of("superman", "joker", "batman")));
    }
}