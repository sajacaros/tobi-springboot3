package kr.study.springboot.config.autoconfig;

import kr.study.springboot.config.MyAutoConfiguration;
import kr.study.springboot.config.MyConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.Map;
import java.util.Objects;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {
    @Bean
    BeanPostProcessor propertyPostProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                MyConfigurationProperties annotation = AnnotationUtils.findAnnotation(bean.getClass(), MyConfigurationProperties.class);
                if(Objects.isNull(annotation)) {
                    return bean;
                }

                Map<String, Object> attr = AnnotationUtils.getAnnotationAttributes(annotation);
                String prefix = (String)attr.get("prefix");

                System.out.println("Binding properties with prefix: " + prefix + " to bean: " + beanName);

                return Binder.get(env).bindOrCreate(prefix, bean.getClass());
            }
        };
    }

}
