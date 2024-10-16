package com.example.spring20240924.Control;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("main7")

public class Controller07 {

    @RequestMapping("sub1")
    public void sub1(WebRequest request) {

        request.setAttribute("data", "손흥민", RequestAttributes.SCOPE_REQUEST);
        // /WEB-INF/view/main7sub1.jsp 로 request forwarding
    }

    @RequestMapping("sub2")
    public void sub2(Model model) {
        model.addAttribute("person", "이강인");


    }

}