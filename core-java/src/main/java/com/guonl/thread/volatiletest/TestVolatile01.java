package com.guonl.thread.volatiletest;

import org.junit.Test;

/**
 * Created by guonl
 * Date 2018/4/3 下午1:51
 * Description: 使用volatile关键字来验证成员变量的读取问题
 * 参考文章：https://www.cnblogs.com/tangyanbo/p/6538488.html
 */
public class TestVolatile01 implements Runnable{

//    boolean running = true;// 如果这样写，就会出现死循环，因为线程读取到自己的本地内存永远都是true
                            // 解决共享变量可见性问题，需要用volatile关键字修饰

    volatile boolean running = true;//这样不会出现死循环，因为已经将这个变量实时同步到主内存中了
//    1. 对volatile变量的写会立即刷新到主存
//    2. 对volatile变量的读会读主存中的新值

    int i = 0;

    @Override
    public void run() {
        // running作为成员变量存在，存储在主内存中，如果没有volatile字段修饰，
        // 线程会从主内存的共享内存中读取一份到自己的本地内存中，也叫做"共享内存的副本"，
        // 每个线程都有自己的本地内存，目的是为了减少和主存通信的频率，提高效率
        while (running){
            i++;
        }
    }

    @Test
    public void test() throws InterruptedException {
        TestVolatile01 volatile01 = new TestVolatile01();
        Thread th = new Thread(volatile01);
        th.run();
        Thread.sleep(10);
        volatile01.running = false;
        Thread.sleep(1000);
        System.out.println(volatile01.i);
        System.out.println("线程结束");
    }

    public static void main(String[] args) throws InterruptedException {

        TestVolatile01 volatile01 = new TestVolatile01();
        Thread th = new Thread(volatile01);
        th.run();
        Thread.sleep(10);
        volatile01.running = false;
        Thread.sleep(1000);
        System.out.println(volatile01.i);
        System.out.println("使用main方法：线程结束");

    }

    /**
     *  .--,       .--,
     * ( (  \.---./  ) )
     *  '.__/o   o\__.'
     *     {=  ^  =}
     *      >  -  <
     *     /       \
     *    //       \\
     *   //|   .   |\\
     *   "'\       /'"_.-~^`'-.
     *      \  _  /--'         `
     *    ___)( )(___
     *   (((__) (__)))    高山仰止,景行行止.虽不能至,心向往之。
     */





}
