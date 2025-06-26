package org.lizheng59;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.ManagedBean;

@SpringBootApplication(scanBasePackages = {"org.lizheng59.newDemo.**"})
//@EnableAspectJAutoProxy(proxyTargetClass = true) // 强制使用 CGLIB
public class NewDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewDemoApplication.class, args);
    }
//    @Bean
//    public FactoryBean<Object> proxiedMyController(MyController myController) {
//        return new ControllerProxyFactory(myController);
//    }
}
