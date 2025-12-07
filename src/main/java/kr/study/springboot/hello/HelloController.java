package kr.study.springboot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@MyRestController
@RequestMapping("/hello")
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public String hello(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name parameter is required");
        }
        return helloService.sayHello(name);
    }
}
