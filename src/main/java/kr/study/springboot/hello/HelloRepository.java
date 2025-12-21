package kr.study.springboot.hello;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public interface HelloRepository {
    Hello findHello(String name);

    void increaseCount(String name);

    default int countOf(String name) {
        Hello ret = findHello(name);
        if (ret == null) {
            return 0;
        }
        return ret.count();
    }

    @Repository
    class Default implements HelloRepository {
        private final JdbcTemplate jdbcTemplate;

        public Default(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        @Override
        public Hello findHello(String name) {
            try {
                return jdbcTemplate.queryForObject(
                        "select name, count from hello where name = '"+name+"'",
                        (rs, rowNum) -> new Hello(
                                rs.getString("name"),
                                rs.getInt("count")
                        )
                );
            } catch (DataAccessException e) {
                return null;
            }
        }

        @Override
        public void increaseCount(String name) {
            Hello hello = findHello(name);
            if (hello == null) {
                jdbcTemplate.update(
                        "insert into hello (name, count) values (?, ?)",
                        name, 1
                );
            } else {
                jdbcTemplate.update(
                        "update hello set count = ? where name = ?",
                        hello.count() + 1, name
                );
            }
        }
    }
}
