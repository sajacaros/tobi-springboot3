package kr.study.springboot.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector { // ImportSelector
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "kr.study.springboot.config.autoconfig.TomcatWEbServerConfig",
                "kr.study.springboot.config.autoconfig.DispatcherServletConfig"
        };
    }
}
