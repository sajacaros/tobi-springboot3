package kr.study.springboot.config.autoconfig;

import kr.study.springboot.config.ConditionalMyOnClass;
import kr.study.springboot.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration //관례
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Bean("tomcatWebServerConfig")
    public ServletWebServerFactory servletContainer() {
        return new TomcatServletWebServerFactory();
    }
}
