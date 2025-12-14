package kr.study.springboot.config.autoconfig;

import kr.study.springboot.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration //관례
public class JettyWebServerConfig {
    @Bean("jettyWebServerConfig")
    public ServletWebServerFactory servletContainer() {
        return new JettyServletWebServerFactory();
    }
}
