package kr.study.springboot;

import kr.study.springboot.hello.HelloController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HelloControllerTest {
    @Test
    void helloController() {
        HelloController helloController = new HelloController(name -> name);
        String ret = helloController.hello("dukim");
        assertThat(ret).isEqualTo("dukim");
    }

    @Test
    void nullHelloController() {
        HelloController helloController = new HelloController(name -> name);
        assertThatThrownBy(
                () -> helloController.hello(null),
                "name이 null일 경우 NPE 발생"
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void emptyHelloController() {
        HelloController helloController = new HelloController(name -> name);
        assertThatThrownBy(
                () -> helloController.hello(""),
                "name이 null일 경우 NPE 발생"
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
