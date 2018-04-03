package com.guonl.reflection;

/**
 * Created by guonl
 * Date 2018/4/3 下午4:48
 * Description:
 */
public class ReflectServiceImpl implements ReflectService{
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
