package kr.study.springboot;

import kr.study.springboot.hello.HelloDecorator;
import kr.study.springboot.hello.HelloService;
import kr.study.springboot.hello.SimpleHelloService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {
    @Test
    void simpleHelloService() {
        HelloService helloService = new SimpleHelloService();
        String ret = helloService.sayHello("dukim");
        assertThat(ret).isEqualTo("Hello dukim");
    }

    @Test
    void helloDecorator() {
        HelloService helloService = new HelloDecorator(name -> name);
        String ret = helloService.sayHello("dukim");
        assertThat(ret).isEqualTo("*dukim*");
    }
}
