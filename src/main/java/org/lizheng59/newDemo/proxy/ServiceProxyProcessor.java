package org.lizheng59.newDemo.proxy;

import org.lizheng59.newDemo.annotation.EnableServiceProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.Arrays;
@Component
public class ServiceProxyProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 检查bean实现的接口是否带@EnableServiceProxy
        Class<?> proxyInterface = Arrays.stream(bean.getClass().getInterfaces())
                .filter(intf -> intf.isAnnotationPresent(EnableServiceProxy.class))
                .findFirst()
                .orElse(null);

        if (proxyInterface != null) {
            EnableServiceProxy annotation = proxyInterface.getAnnotation(EnableServiceProxy.class);
            // 1. 检查是否启用代理
            if (!annotation.enabled()) {
                return bean;
            }
            System.out.println(annotation);
            // 创建代理对象
            return Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    new Class[]{proxyInterface},
                    new ServiceProxy(bean, annotation)
//                    (proxy, method, args) -> {
//                        System.out.println("=== 代理前置处理 ===");
//                        Object result = method.invoke(bean, args);
//                        System.out.println("=== 代理后置处理 ===");
//                        return result;
//                    }
            );
        }
        return bean;
    }
}
