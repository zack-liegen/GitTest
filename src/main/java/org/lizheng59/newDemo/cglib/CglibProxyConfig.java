/**
 * 配置类注册
 * */
package org.lizheng59.newDemo.cglib;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CglibProxyConfig {

    @Bean
    public static ControllerCglibProxyProcessor controllerCglibProxyProcessor() {
        return new ControllerCglibProxyProcessor();
    }
}
