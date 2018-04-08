package com.guonl.lambda;

/**
 * Created by guonl
 * Date 2018/4/3 下午9:17
 * Description:
 */
public class Person {

    private String name;
    private int age;

    public Person(int i) {
        name = "name" + i;
    }

    public Person(int i, int age) {
        name = "name" + i;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
