package kr.study.springboot.hello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@HellobootTest
@Transactional
public class JdbcTemplateTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello (name varchar(50) primary key, count int)");
    }

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into hello (name, count) values (?, ?)", "hello", 1);
        jdbcTemplate.update("insert into hello (name, count) values (?, ?)", "world", 3);

        Integer count = jdbcTemplate.queryForObject("select count from hello where name = ?", Integer.class, "hello");
        assertThat(count).isEqualTo(1);

        count = jdbcTemplate.queryForObject("select count from hello where name = ?", Integer.class, "world");
        assertThat(count).isEqualTo(3);
    }

}
