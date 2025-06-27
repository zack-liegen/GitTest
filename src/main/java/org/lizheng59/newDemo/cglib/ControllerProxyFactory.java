package org.lizheng59.newDemo.cglib;

public class ControllerProxyFactory {

//    public static <T> T createProxy(T target, Class<T> interfaceType) {
//        Objects.requireNonNull(target);
//        Objects.requireNonNull(interfaceType);
//
//        // 验证目标对象确实实现了指定接口
//        if (!interfaceType.isInstance(target)) {
//            throw new IllegalArgumentException(
//                    target.getClass() + " does not implement " + interfaceType
//            );
//        }
//
//        Object proxy = Proxy.newProxyInstance(
//                target.getClass().getClassLoader(),
//                new Class<?>[]{interfaceType}, // 明确指定接口
//                new ServiceProxy(target)
//        );
//
//        return interfaceType.cast(proxy); // 安全转换
//    }
}
