package com.guonl.annotation.blog;

import java.lang.annotation.*;

/**
 * Created by guonl
 * Description: key的注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Key {
}
