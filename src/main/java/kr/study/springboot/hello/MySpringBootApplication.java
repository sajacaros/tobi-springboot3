package kr.study.springboot.hello;

import kr.study.springboot.config.EnableMyAutoConfig;
import kr.study.springboot.config.autoconfig.DispatcherServletConfig;
import kr.study.springboot.config.autoconfig.TomcatWebServerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ComponentScan
@Configuration
@EnableMyAutoConfig
public @interface MySpringBootApplication {
}
