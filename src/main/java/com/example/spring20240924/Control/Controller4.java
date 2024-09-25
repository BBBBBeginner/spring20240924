package com.example.spring20240924.Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main4") //컨트롤러 내의 핸들러 메소드 경로 앞부분
public class Controller4 {

//request handler method
    //https://docs.spting.io/spring-framework/reference/web/webmvc/mvc-controller/ann-methods.html

    //localhost:8080/main/sub1
    @RequestMapping("sub1")
    public void sub1(){
        System.out.println("Controller4.sub1");
    }

    @RequestMapping("sub2")
    public void sub2(){
        System.out.println("Controller4.sub2 수정!!!");
    }

}
