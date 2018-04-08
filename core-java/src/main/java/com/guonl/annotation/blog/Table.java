package com.guonl.annotation.blog;

import java.lang.annotation.*;

/**
 * Created by guonl
 * Description: 表名的注解
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Table {
    String name() default "";
}
