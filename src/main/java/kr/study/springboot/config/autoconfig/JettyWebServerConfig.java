package kr.study.springboot.config.autoconfig;

import kr.study.springboot.config.ConditionalMyOnClass;
import kr.study.springboot.config.EnableMyConfigurationProperties;
import kr.study.springboot.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration //관례
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
@EnableMyConfigurationProperties(ServerProperties.class)
public class JettyWebServerConfig {
    @Bean("jettyWebServerConfig")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletContainer(ServerProperties serverProperties) {
        JettyServletWebServerFactory serverFactory = new JettyServletWebServerFactory();
        serverFactory.setContextPath(serverProperties.getContextPath());
        serverFactory.setPort(serverProperties.getPort());
        return serverFactory;
    }
}
