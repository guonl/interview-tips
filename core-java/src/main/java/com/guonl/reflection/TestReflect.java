package com.guonl.reflection;

import java.lang.reflect.Method;

/**
 * Created by guonl
 * Date 2018/4/3 下午4:51
 * Description:
 */
public class TestReflect {

    public static ReflectService getInstance(String serviceFullName) {
        ReflectService result = null;
        try {
            result = (ReflectService) Class.forName(serviceFullName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 假设只有一个参数param
     *
     * @param serviceName
     * @param param
     * @return
     */
    public static ReflectService getInstanceWithConstuctorParam(String serviceName, String param) {
        ReflectService result = null;
        try {
            result = (ReflectService) Class.forName(serviceName).getConstructor(String.class).newInstance(param);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        //无参数构造方法反射
        ReflectService service = getInstance("com.guonl.reflection.ReflectServiceImpl");
        service.sayHello("小明");
        //有参数构造方法反射
        ReflectService service2 = getInstanceWithConstuctorParam("com.guonl.reflection.ReflectionServiceImpl2", "小花");
        service2.sayHello("中国");
        //反射执行方法
        System.out.println(service2.getClass());
        try {
            //有参数
            Method method = service2.getClass().getMethod("sayToTwo", String.class, String.class);
            method.invoke(service2, "person1", "person2");
            //无参数
            Method method2 = service2.getClass().getMethod("sayHello");
            method2.invoke(service2);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
