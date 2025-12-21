package kr.study.springboot.config.autoconfig;

import kr.study.springboot.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {

    @Bean
    public ServerProperties serverProperties(Environment environment) {
        ServerProperties properties = new ServerProperties();

        String contextPath = environment.getProperty("contextPath", "");
        int port = Integer.parseInt(environment.getProperty("port", "9000"));
        properties.setContextPath(contextPath);
        properties.setPort(port);

        return properties;
    }
}
