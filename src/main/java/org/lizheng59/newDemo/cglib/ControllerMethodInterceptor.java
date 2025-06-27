/**
 * 方法拦截器实现
 * **/
package org.lizheng59.newDemo.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class ControllerMethodInterceptor implements MethodInterceptor {
    private final Object target;
    public ControllerMethodInterceptor(Object target) {
        this.target = target;
    }
    public static Object createProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new ControllerMethodInterceptor(target));
        return enhancer.create();  // 创建代理实例
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // 排除Object基础方法
//        if (method.getDeclaringClass() == Object.class) {
//            return proxy.invokeSuper(obj, args);
//        }
        try {
            System.out.printf("[CGLIB] Before %s.%s()\n",
                    target.getClass().getSimpleName(),
                    method.getName());
            Object result = proxy.invokeSuper(obj, args);
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
    public static Object ControllerCglibProxyGenerator (Class target){
        // 创建加强器，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        // 为代理类指定需要代理的类，也即是父类
        enhancer.setSuperclass(target);
        // 设置方法拦截器回调引用，对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept() 方法进行拦截
        enhancer.setCallback(new ControllerMethodInterceptor(target));
        // 创建cglib 代理类
        return enhancer.create();
    }
}

