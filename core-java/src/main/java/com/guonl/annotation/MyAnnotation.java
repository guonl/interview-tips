package com.guonl.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Inherited//并不能从接口继承,方法上面的也不行,只有类上的可以
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
String name() default "";
String say() default "hello";
int age() default -1;
}
