package org.example.Proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 抽象主题接口
 */
interface UserService {
    void addUser(String username);
    void deleteUser(String username);
}
/**
 * 真实主题实现类
 */
class UserServiceImpl implements UserService {
    @Override
    public void addUser(String username) {
        System.out.println("添加用户: " + username);
    }
    @Override
    public void deleteUser(String username) {
        System.out.println("删除用户: " + username);
    }
}
/**
 * 动态代理处理器
 */
class UserServiceProxyHandler implements InvocationHandler {
    private final Object target;  // 被代理的真实对象
    public UserServiceProxyHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 前置增强
        System.out.println("[代理] 开始执行 " + method.getName() + " 方法");
        long startTime = System.currentTimeMillis();
        // 调用真实对象的方法
        Object result = method.invoke(target, args);
        // 后置增强
        long endTime = System.currentTimeMillis();
        System.out.println("[代理] 方法执行完成，耗时: " + (endTime - startTime) + "ms");
        return result;
    }
}
public class Proxy2 {
    public static void main(String[] args) {
        // 创建真实对象
        UserService realService = new UserServiceImpl();
        // 创建代理对象
        UserService proxyInstance = (UserService) Proxy.newProxyInstance(
                realService.getClass().getClassLoader(),  // 类加载器
                realService.getClass().getInterfaces(),   // 实现的接口
                new UserServiceProxyHandler(realService)  // 调用处理器
        );
        // 通过代理对象调用方法
        proxyInstance.addUser("张三");
        proxyInstance.deleteUser("李四");
        // 输出代理类名
        System.out.println("代理类: " + proxyInstance.getClass().getName());
    }
}
