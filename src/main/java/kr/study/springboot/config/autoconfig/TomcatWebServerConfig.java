package kr.study.springboot.config.autoconfig;

import kr.study.springboot.config.ConditionalMyOnClass;
import kr.study.springboot.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration //관례
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Value("${contextPath}")
    String contextPath;

    @Bean("tomcatWebServerConfig")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletContainer() {
        System.out.println("contextPath = " + contextPath);
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        serverFactory.setContextPath(contextPath);
        return serverFactory;
    }
}
