package kr.study.springboot.hello;

import kr.study.springboot.config.MySpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MySpringBootApplication
public class SpringbootApplication {

    @Value("${spring.application.name}")
    private String appName;

    @Bean
    ApplicationRunner applicationRunner(Environment environment) {
        return args -> {
            System.out.println("Hello, Spring Boot!, " + appName);
        };
    }

    public static void main(String[] args) {
        // MySpringApplication.run(SpringbootApplication.class, args);
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
