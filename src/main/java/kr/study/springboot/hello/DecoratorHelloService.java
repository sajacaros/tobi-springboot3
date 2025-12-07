package kr.study.springboot.hello;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DecoratorHelloService implements HelloService {
    private final HelloService helloService;
    public DecoratorHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return "*" + helloService.sayHello(name) + "*";
    }
}
