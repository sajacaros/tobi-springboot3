package kr.study.springboot.config.autoconfig;

import kr.study.springboot.config.ConditionalMyOnClass;
import kr.study.springboot.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration //관례
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {
    @Bean("jettyWebServerConfig")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletContainer() {
        return new JettyServletWebServerFactory();
    }
}
