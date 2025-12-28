package kr.study.springboot.hello;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringbootApplication {

    final JdbcTemplate jdbcTemplate;

    public SpringbootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init() {
        jdbcTemplate.execute("create table if not exists hello (name varchar(50) primary key, count int)");
    }
    public static void main(String[] args) {
        // MySpringApplication.run(SpringbootApplication.class, args);
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
