package kr.study.springboot;

import kr.study.springboot.hello.HelloDecorator;
import kr.study.springboot.hello.HelloService;
import kr.study.springboot.hello.SimpleHelloService;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;

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
}
