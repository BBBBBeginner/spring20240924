package com.example.spring20240924.Control;


import com.example.spring20240924.dto.c14.Actor;
import com.example.spring20240924.dto.c14.Book;
import com.example.spring20240924.dto.c14.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("main14")
public class Controller14 {
    @RequestMapping("sub1")
    public void method1(Model model) {
        model.addAttribute("list", List.of(
                new Book("java", "shin", "hanbit", 1000, 5000),
                new Book("git", "linus", "scm", 200, 3000),
                new Book("react", "adam", "meta", 450, 40000),
                new Book("vue", "captin", "apple", 700, 35000)
        ));

        model.addAttribute("members", List.of(
                new Member("흥민", 183, 78, "07/08", "토트넘", "FW"),
                new Member("강인", 173, 72, "02/08", "파리", "MF"),
                new Member("현우", 193, 75, "03/08", "울산", "Gk"),
                new Member("희찬", 176, 77, "04/08", "울버햄튼", "MF")
        ));

    }


    @RequestMapping("sub2")
    public void method2(Model model) {
        model.addAttribute("actor", new Actor("이정재", "컴퍼니", "12/15", "enfj",
                List.of("오징어게임", "신세계", "관상", "도둑들")));


        model.addAttribute("actorList",
                List.of(
                        new Actor("lee", "com1", "01/01", "isfj",
                                List.of("game", "man", "thiefs")),
                        new Actor("kim", "com2", "02/02", "esfj",
                                List.of("movie", "film1", "drama1")),
                        new Actor("choi", "sm", "03/03", "intp",
                                List.of("movie2", "film2", "show1")),
                        new Actor("park", "yg", "04/04", "isfp",
                                List.of("movie3", "film3", "show2")),
                        new Actor("son", "hove", "05/02", "infp",
                                List.of("baseball", "man", "show3"))));
    }
}
