/**
 * 方法拦截器实现
 * **/
package org.lizheng59.newDemo.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class ControllerMethodInterceptor implements MethodInterceptor {

    private final Object target;

    public ControllerMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // 排除Object基础方法
        if (method.getDeclaringClass() == Object.class) {
            return proxy.invokeSuper(obj, args);
        }

        System.out.printf("[CGLIB] Before %s.%s()\n",
                target.getClass().getSimpleName(),
                method.getName());

        try {
            Object result = proxy.invoke(target, args);
            System.out.printf("[CGLIB] After %s.%s()\n",
                    target.getClass().getSimpleName(),
                    method.getName());
            return result;
        } catch (Exception e) {
            System.err.printf("[CGLIB] Error in %s.%s(): %s\n",
                    target.getClass().getSimpleName(),
                    method.getName(),
                    e.getMessage());
            throw e;
        }
    }
}
