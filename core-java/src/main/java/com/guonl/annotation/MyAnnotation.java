package com.guonl.annotation;

import java.lang.annotation.*;

/**
 * Created by guonl
 * Date 2018/4/8 下午2:29
 * Description: 自定义自己的注解 @MyAnnotation
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Inherited//并不能从接口继承,方法上面的也不行,只有类上的可以
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
String name() default "";
String say() default "hello";
int age() default -1;
}
