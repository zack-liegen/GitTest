package org.lizheng59.newDemo.cglib;

import net.sf.cglib.proxy.Enhancer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.bind.annotation.RestController;

public class ControllerCglibProxyProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 只代理RestController
        if (bean.getClass().isAnnotationPresent(RestController.class)) {
            return createCglibProxy(bean);
        }
        return bean;
    }

    private Object createCglibProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new ControllerMethodInterceptor(target));

        // 解决Controller无默认构造器问题
        enhancer.setStrategy(new BeanFactoryAwareGeneratorStrategy());

        return enhancer.create();
    }
}
