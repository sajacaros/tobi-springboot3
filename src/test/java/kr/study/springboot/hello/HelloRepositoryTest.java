package kr.study.springboot.hello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@HellobootTest
public class HelloRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    HelloRepository helloRepository;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello (name varchar(50) primary key, count int)");
    }

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
