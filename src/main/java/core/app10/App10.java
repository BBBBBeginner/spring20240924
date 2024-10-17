package core.app10;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App10 {
    public static void main(String[] args) {

        BeanFactory context = SpringApplication.run(App10.class, args);
        Component1 b1 = context.getBean(Component1.class);
        Component2 b2 = context.getBean(Component2.class);

        System.out.println(b1.getComponent2()); // not null
        System.out.println(b1.getComponent2() == b2); // true

    }
}