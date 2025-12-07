package kr.study.springboot;

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
}
