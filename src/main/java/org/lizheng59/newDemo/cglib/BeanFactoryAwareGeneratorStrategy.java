package org.lizheng59.newDemo.cglib;

import net.sf.cglib.core.DefaultGeneratorStrategy;
import net.sf.cglib.proxy.Enhancer;

public class BeanFactoryAwareGeneratorStrategy extends DefaultGeneratorStrategy {
    @Override
    protected Object create(Object key) {
        // 允许代理非public构造器的类
        Enhancer.EnhancerKey enhancerKey = (Enhancer.EnhancerKey) key;
        if (enhancerKey.getArgumentTypes().length > 0) {
            return super.create(key);
        }
        return null; // 触发使用无参构造器
    }
}
