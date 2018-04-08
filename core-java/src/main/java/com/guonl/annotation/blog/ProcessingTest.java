package com.guonl.annotation.blog;

/**
 * Created by guonl
 * Description: 测试方法
 */

public class ProcessingTest {

    public static void main(String[] args) throws NumException, IllegalAccessException {
        People people = new People();
        people.setId("ccc");
        people.setName("姓名");
        people.setAge(18);
        people.setSex("男");
        System.out.println(new Processing().save(people));
    }
}
