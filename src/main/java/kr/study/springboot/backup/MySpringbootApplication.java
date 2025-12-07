package kr.study.springboot.backup;

import kr.study.springboot.SpringbootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class MySpringbootApplication {
    @Bean
    public ServletWebServerFactory servletContainer() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
        // 스프링 컨테이너에 등록되는 시점에 ApplicationContext를 주입
        // 빈의 라이프 사이클을 담당하는 ApplicationContextAware 인터페이스의 setApplicationContext 메소드를 구현하고 있으면 applicationContext를 주입받을 수 있음
        // DispatcherServlet은 FrameworkServlet을 상속하고 있으며 ApplicationContextAware의 setApplicationContext 메서드를 구현함
        // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/FrameworkServlet.html
        // 스프링을 이용할땐 ApplicationContextAware를 구현하기 보단 생성자를 통해 주입받는것이 깔끔해 보임
    }

    public static void main(String[] args) {
        MySpringApplication.run(SpringbootApplication.class, args);
        // SpringApplication.run(MySpringbootApplication.class, args);
    }
}
