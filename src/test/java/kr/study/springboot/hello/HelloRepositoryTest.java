package kr.study.springboot.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HelloRepositoryTest {
    @Autowired
    HelloRepository helloRepository;

    @Test
    void findHello_not_exist() {
        assertThat(helloRepository.findHello("notExist")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("hello")).isEqualTo(0);
        helloRepository.increaseCount("hello");
        assertThat(helloRepository.countOf("hello")).isEqualTo(1);
        helloRepository.increaseCount("hello");
        assertThat(helloRepository.countOf("hello")).isEqualTo(2);
    }
}
