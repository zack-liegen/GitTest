package org.lizheng59.newDemo.proxy;

import org.lizheng59.newDemo.annotation.EnableServiceProxy;
import org.lizheng59.newDemo.annotation.FunctionParamers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class ServiceProxy implements InvocationHandler {
    private final Object target; // 被代理的真实
    private final EnableServiceProxy annotation;

    public ServiceProxy(Object target, EnableServiceProxy annotation) {
        this.target = target;
        this.annotation = annotation;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 调用原始方法
        try {
            FunctionParamers functionParamers = method.getAnnotation(FunctionParamers.class);
            System.out.println("*** Before " + method.getName() + " ***" + new Date());
            Object result = method.invoke(target, args);
//            if( functionParamers == null ){
//                System.out.println("后置方法");
//            } else {
//                System.out.println("后置方法"+functionParamers.url());
//            }
            return result;
        } catch (Exception e) {
            System.err.println("方法执行失败: " + method.getName());
            throw e;
        }

    }
}
