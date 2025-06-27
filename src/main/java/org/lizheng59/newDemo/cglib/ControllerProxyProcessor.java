package org.lizheng59.newDemo.cglib;

import org.lizheng59.newDemo.annotation.EnableControllerProxy;
import org.lizheng59.newDemo.annotation.EnableServiceProxy;
import org.lizheng59.newDemo.proxy.ServiceProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.Arrays;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE) // 确保最先执行
public class ControllerProxyProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        EnableControllerProxy annotation =
                AnnotationUtils.findAnnotation(bean.getClass(), EnableControllerProxy.class);

        if (annotation  != null) {
            System.out.println("[CGLIB] Proxying: " + beanName);
            if (!annotation.enabled()) {
                return bean;
            }
            return ControllerMethodInterceptor.createProxy(bean);
        }
        return bean;
    }
}
