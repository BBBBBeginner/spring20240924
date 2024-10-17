package core.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App1 {
    public static void main(String[] args) {
        SpringApplication.run(App1.class, args); //main 메서드가 실행되면서 알아서 실행
        Controller1 c1 = new Controller1();
        c1.method1();
        c1.method1();
    }
}

class Controller1 {
    public void method1() {
        System.out.println("Controller1.method1");

    }
}
