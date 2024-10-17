package com.example.spring20240924.Control;

import com.example.spring20240924.mapper.Mapper03;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main33")
@RequiredArgsConstructor
public class Controller33 {
    private final Mapper03 mapper03;

    @RequestMapping("sub1")
    public void sub1() {
        String d = mapper03.getDescription();
        System.out.println("d =" + d);
    }
}
