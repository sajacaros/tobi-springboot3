package kr.study.springboot;

import kr.study.springboot.hello.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class SpringbootApplication {
    public static void main(String[] args) {
        // MySpringApplication.run(SpringbootApplication.class, args);
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
