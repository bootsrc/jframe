package com.bootsrc.aop.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AuthMethod {
    /**
     * 表示是否需要权限认证(value = needAuth)
     * @return
     */
    boolean value() default true;
}
