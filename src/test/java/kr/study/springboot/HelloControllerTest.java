package kr.study.springboot;

import kr.study.springboot.hello.HelloController;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HelloControllerTest {
    @Test
    void helloControllerTest() {
        HelloController helloController = new HelloController(name -> name);
        String result = helloController.hello("World");
        assertThat(result).isEqualTo("World");
    }

    @UnitTest
    void nullArgumentTest() {
        HelloController helloController = new HelloController(name -> name);
        assertThatThrownBy(() -> {
                    helloController.hello(null);
                }, "", IllegalArgumentException.class);

    }

    @FastUnitTest
    void emptyArgumentTest() {
        HelloController helloController = new HelloController(name -> name);
        assertThatThrownBy(() -> {
            helloController.hello("");
        }, "", IllegalArgumentException.class);

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @UnitTest
    @interface FastUnitTest {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
    @Test
    @interface UnitTest {
    }
}
