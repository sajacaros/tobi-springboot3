package kr.study.springboot;

import kr.study.springboot.hello.HelloService;
import kr.study.springboot.hello.SimpleHelloService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {
    @Test
    void testHelloService() {
        HelloService helloService = new SimpleHelloService();
        String result = helloService.sayHello("World");
        assertThat(result).isEqualTo("Hello World");
    }
}
