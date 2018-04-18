package com.guonl.thread02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by guonl
 * Date 2018/4/18 上午11:17
 * Description:
 */
public class VolatileDemo {
    
    private int number = 0;

    private Lock lock = new ReentrantLock();

    public int getNumber() {
        return this.number;
    }

    public void increase(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 为什么会出现结果不等于500的情况，因为number++ 并不是原子的操作
        // 1、先从主内存中读取到number  2、再对number增一  3、最后将number的值写到主内存中
        /**
         * 实现方法一：通过synchronized
         */
//        synchronized (this){
//            this.number ++;
//        }
        /**
         * 方法二：使用可重入锁：ReentrantLock()
         */
        lock.lock();
        try {
            this.number++;
        } finally {
            lock.unlock();
        }
    }


    private static void test(){
        final VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0; i < 500; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    volatileDemo.increase();
                }
            }).start();
        }

        //如果还有子线程在运行，主线程就让出CPU资源
        //直到所有的子线程都运行完了，主线程往下执行
        while (Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println("name：" + volatileDemo.getNumber());

    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            test();
        }
    }

}
