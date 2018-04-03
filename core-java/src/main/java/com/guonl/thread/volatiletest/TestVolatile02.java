package com.guonl.thread.volatiletest;

import org.junit.Test;

/**
 * Created by guonl
 * Date 2018/4/3 下午2:14
 * Description: 如果不使用volatile也可以解决死循环的问题，参考demo
 */
public class TestVolatile02 implements Runnable{

    boolean running = true;// 不使用volatile，则需要使用同步的get和set方法
//    虽然running变量上没有volatile关键字修饰，但是读和写running都是同步方法
//
//    同步块存在如下语义：
//            1.进入同步块，访问共享变量会去读取主存
//            2.退出同步块，本地内存对共享变量的修改会立即刷新到主存
//              因此上述代码不会出现死循环。

    int i = 0;

    @Override
    public void run() {
        while (this.isRunning()){
            i++;
        }
    }

    @Test
    public void test() throws InterruptedException {
        TestVolatile02 volatile02 = new TestVolatile02();
        Thread th = new Thread(volatile02);
        th.run();
        Thread.sleep(10);
        volatile02.setRunning(false);//
        System.out.println(volatile02.i);
        System.out.println("线程结束");
    }

    public synchronized boolean isRunning() {
        return running;
    }

    public synchronized void setRunning(boolean running) {
        this.running = running;
    }
}
