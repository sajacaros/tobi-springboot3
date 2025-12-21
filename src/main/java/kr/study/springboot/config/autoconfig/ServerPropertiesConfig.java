package kr.study.springboot.config.autoconfig;

import kr.study.springboot.config.MyAutoConfiguration;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {

    @Bean
    public ServerProperties serverProperties(Environment environment) {
        return Binder.get(environment).bind("my", ServerProperties.class).get();
    }
}
