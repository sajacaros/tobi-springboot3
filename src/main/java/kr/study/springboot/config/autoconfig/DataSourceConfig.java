package kr.study.springboot.config.autoconfig;

import com.zaxxer.hikari.HikariDataSource;
import kr.study.springboot.config.ConditionalMyOnClass;
import kr.study.springboot.config.EnableMyConfigurationProperties;
import kr.study.springboot.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;
import java.sql.SQLException;

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties.class) // 위 condition이 활성화 될때만 MyDataSourceProperties 빈 생성
public class DataSourceConfig {
    @Bean
    @ConditionalMyOnClass("com.zaxxer.hikari.HikariDataSource")
    DataSource hikariDataSource(MyDataSourceProperties dataSourceProperties) throws ClassNotFoundException, SQLException {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        dataSource.setJdbcUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());

        return dataSource;
    }

    @Bean
    @ConditionalOnMissingBean
    DataSource dataSource(MyDataSourceProperties dataSourceProperties) throws ClassNotFoundException, SQLException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(dataSourceProperties.getDriverClassName()));
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());

        return dataSource;
    }
}
