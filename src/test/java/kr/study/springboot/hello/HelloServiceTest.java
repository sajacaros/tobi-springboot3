package kr.study.springboot.hello;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloServiceTest {
    @UnitTest
    void simpleHelloService() {
        HelloService helloService = new SimpleHelloService();
        String ret = helloService.sayHello("dukim");
        assertThat(ret).isEqualTo("Hello dukim");
    }

    @FastUnitTest
    void helloDecorator() {
        HelloService helloService = new HelloDecorator(name -> name);
        String ret = helloService.sayHello("dukim");
        assertThat(ret).isEqualTo("*dukim*");
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
