package com.guonl.functionalInterface;

/**
 * Created by guonl
 * Date 2018/5/29 下午5:41
 * Description: 文章地址：https://blog.csdn.net/u012901117/article/details/77585002
 */
@FunctionalInterface
public interface GofFunction<T1,T2> {
    void execute(T1 t1,T2 t2);
}
