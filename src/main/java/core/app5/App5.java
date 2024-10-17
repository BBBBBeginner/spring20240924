package core.app5;

import core.app3.Service.Service1;
import core.app5.controller.Controller1;
import core.app5.controller.Controller2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;  // 스프링 빈을 관리하는 컨텍스트
import org.springframework.beans.factory.BeanFactory;  // 스프링의 BeanFactory

@SpringBootApplication
public class App5 {
    public static void main(String[] args) {
        // Inversion of Control (IOC)
        // 객체 생성, DI

        BeanFactory factory = SpringApplication.run(App5.class, args);

        Controller1 c1 = factory.getBean(Controller1.class);
        Controller2 c2 = factory.getBean(Controller2.class);
        Service1 s1 = factory.getBean(Service1.class);

        System.out.println("c1 =" + c1);
        System.out.println("c2 =" + c2);
        System.out.println("s1 =" + s1);

        System.out.println(c1.getService1()); // null
        System.out.println(c2.getService1()); // null


        c1.getService1();
        c2.getService1();
    }
}
