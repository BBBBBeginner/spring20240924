package core.app9;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App9 {
    public static void main(String[] args) {
        BeanFactory context = SpringApplication.run(App9.class, args);
        Comp1 c1 = context.getBean(Comp1.class);
        Comp2 c2 = context.getBean(Comp2.class);

        System.out.println("c2 = " + c2);
        System.out.println(c1.getComp2() == c2); // true

    }
}