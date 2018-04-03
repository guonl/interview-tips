package com.guonl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by guonl
 * Date 2018/4/3 下午5:48
 * Description:
 */
public class LogHandler implements InvocationHandler{


    public Object target;

    public Object createProxy(Object target) {
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logging();
        method.invoke(target, args);
        return null;
    }

    private void logging() {
        System.out.println("start logging now!");
    }
}
