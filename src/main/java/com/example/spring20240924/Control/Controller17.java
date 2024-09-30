package com.example.spring20240924.Control;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main17")

public class Controller17 {
    @RequestMapping("sub1")
    public void sub1(Model model) {

    }

    @RequestMapping("sub2")
    public void sub2(Model model) {

    }

    @RequestMapping("sub3")
    public void sub1(Model model,
                     String id,
                     HttpSession session) {
        if (!id.isEmpty() && id != null) {
            System.out.println(id);
            session.setAttribute("id", id);
        }
    }

    @RequestMapping("sub4")
    public void sub4(Model model) {

    }
}
