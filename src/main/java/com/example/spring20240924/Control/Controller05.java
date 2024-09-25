package com.example.spring20240924.Control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main5")
public class Controller05 {

    // ?name=son&address=seoul
    @RequestMapping("sub1")
    public void sub1(@RequestParam("name")String p1,
                     @RequestParam("address")String p2){
        System.out.println("p1="+p1);
        System.out.println("p2="+p2);
    }

    // /main/sub3?name=명보&address=국대
    @RequestMapping("sub2")
    public void sub2(@RequestParam("name")String name,
                     @RequestParam("address")String address){
        System.out.println("name="+name);
        System.out.println("address="+address);
    }

// /main/sub3?name=명보&address=국대
    @RequestMapping("sub3")
    public void sub3(String name,
                     String address){
        System.out.println("name="+name);
        System.out.println("address="+address);
    }
    // /main/sub3?name=희찬
    @RequestMapping("sub4")
    public void sub4(@RequestParam(required = false)String name,
                     @RequestParam(required = false)String address){
        System.out.println("name="+name);
        System.out.println("address="+address);
    }

    //  /main5/sub5?name=흥민&address=런던
    // /main5/sub5?address=제주
    // /main5/sub5?name=강인
    // /main5/sub5
        @RequestMapping("sub5")
    public void sub5(@RequestParam(defaultValue = "게스트2")String name,
                     @RequestParam(defaultValue = "서울역")String address){
        System.out.println("name="+name);
        System.out.println("address="+address);
    }
}


