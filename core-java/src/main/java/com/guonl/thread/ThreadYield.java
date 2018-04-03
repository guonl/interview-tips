package com.guonl.thread;

import org.junit.Test;

/**
 * Created by guonl
 * Date 2018/4/2 下午5:35
 * Description: 线程的礼让（Thread.yield()）方法
 */
public class ThreadYield implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                System.out.println("当前的线程是:" + Thread.currentThread().getName());
                Thread.currentThread().yield();
            }
            System.out.println("执行的是:" + Thread.currentThread().getName());
        }
    }


    @Test
    public void test() {
        ThreadYield yield = new ThreadYield();
        Thread thread = new Thread(yield, "花花");
        Thread thread1 = new Thread(yield, "草草");
        thread.start();
        thread1.start();
    }

    /**
     * 使当前线程从执行状态（运行状态）变为可执行态（就绪状态）。cpu会从众多的可执行态里选择，
     * 也就是说，当前也就是刚刚的那个线程还是有可能会被再次执行到的，并不是说一定会执行其他线
     * 程而该线程在下一次中不会执行到了。
     *
     * Java线程中有一个Thread.yield( )方法，很多人翻译成线程让步。顾名思义，就是说当一个线程
     * 使用了这个方法之后，它就会把自己CPU执行的时间让掉，让自己或者其它的线程运行。
     *
     */

}
