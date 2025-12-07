package kr.study.springboot.config;

import kr.study.springboot.config.autoconfig.DispatcherServletConfig;
import kr.study.springboot.config.autoconfig.TomcatWEbServerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DispatcherServletConfig.class, TomcatWEbServerConfig.class})
public @interface EnableMyAutoConfiguration {
}
