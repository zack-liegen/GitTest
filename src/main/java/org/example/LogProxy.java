package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;

public class LogProxy {
    /**
     * 生成对象的代理对象，对被代理对象进行所有方法日志增强
     * 参数：原始对象
     * 返回值：被代理的对象
     * JDK 动态代理
     *  基于接口的动态代理
     *  被代理类必须实现接口
     *  JDK提供的
     */
    public static Object getObject(final Object obj){
        /**
         * 创建对象的代理对象
         * 参数一：类加载器
         * 参数二：对象的接口
         * 参数三：调用处理器，代理对象中的方法被调用，都会在执行方法。对所有被代理对象的方法进行拦截
         */
        Object proxyInstance = Proxy.newProxyInstance(obj.getClass().getClassLoader()
                , obj.getClass().getInterfaces(), new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //方法执行前
                        long startTime = System.currentTimeMillis();

                        Object result = method.invoke(obj, args);//执行方法的调用

                        //方法执行后
                        long endTime = System.currentTimeMillis();
                        SimpleDateFormat sdf = new SimpleDateFormat();
                        System.out.printf(String.format("%s方法执行结束时间：%%s ；方法执行耗时：%%d%%n"
                                , method.getName()), sdf.format(endTime), endTime - startTime);
                        return result;
                    }
                });
        return proxyInstance;
    }
    /**
     * 使用CGLib创建动态代理对象
     * 第三方提供的的创建代理对象的方式CGLib
     * 被代理对象不能用final修饰
     * 使用的是Enhancer类创建代理对象
     */
//    public static Object getObjectByCGLib(final Object obj){
//        /**
//         * 使用CGLib的Enhancer创建代理对象
//         * 参数一：对象的字节码文件
//         * 参数二：方法的拦截器
//         */
//        Object proxyObj = Enhancer.create(obj.getClass(), new MethodInterceptor() {
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                //方法执行前
//                long startTime = System.currentTimeMillis();
//
//                Object invokeObject = method.invoke(obj, objects);//执行方法的调用
//
//                //方法执行后
//                long endTime = System.currentTimeMillis();
//                SimpleDateFormat sdf = new SimpleDateFormat();
//                System.out.printf(String.format("%s方法执行结束时间：%%s ；方法执行耗时：%%d%%n"
//                        , method.getName()), sdf.format(endTime), endTime - startTime);
//                return invokeObject;
//            }
//        });
//        return proxyObj;
//    }
}

