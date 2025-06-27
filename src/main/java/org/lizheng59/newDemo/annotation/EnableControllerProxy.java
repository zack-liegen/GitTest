package org.lizheng59.newDemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 只能标注在接口或类上
@Retention(RetentionPolicy.RUNTIME) // 运行时保留
public @interface EnableControllerProxy {
    /**
     * 是否启用代理（默认true）
     */
    boolean enabled() default true;
}
