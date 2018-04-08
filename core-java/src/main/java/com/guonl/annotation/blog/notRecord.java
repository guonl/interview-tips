package com.guonl.annotation.blog;

import java.lang.annotation.*;

/**
 * Created by guonl
 * Description: 不记录的字段
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface notRecord {
}
