package kr.study.springboot.hello;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HelloControllerTest {
    HelloService dummyHelloService = new HelloService() {
        @Override
        public String sayHello(String name) {
            return name;
        }

        @Override
        public Integer countOf(String name) {
            return 0;
        }
    };

    @Test
    void helloController() {
        HelloController helloController = new HelloController(dummyHelloService);
        String ret = helloController.hello("dukim");
        assertThat(ret).isEqualTo("dukim");
    }

    @Test
    void nullHelloController() {
        HelloController helloController = new HelloController(dummyHelloService);
        assertThatThrownBy(
                () -> helloController.hello(null),
                "name이 null일 경우 NPE 발생"
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void emptyHelloController() {
        HelloController helloController = new HelloController(dummyHelloService);
        assertThatThrownBy(
                () -> helloController.hello(""),
                "name이 null일 경우 NPE 발생"
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
