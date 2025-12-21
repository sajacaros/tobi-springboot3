package kr.study.springboot.config.autoconfig;

import kr.study.springboot.config.MyConfigurationProperties;

@MyConfigurationProperties(prefix = "my")
public class ServerProperties {
    String contextPath;
    int port;

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
