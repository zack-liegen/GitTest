package org.lizheng59.newDemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记需要动态代理的Service接口
 */
@Target(ElementType.TYPE) // 只能标注在接口或类上
@Retention(RetentionPolicy.RUNTIME) // 运行时保留
public @interface EnableServiceProxy {
    /**
     * 是否启用代理（默认true）
     */
    boolean enabled() default true;



    /**
     * 需要排除的方法名
     */
    String[] excludeMethods() default {};
}
