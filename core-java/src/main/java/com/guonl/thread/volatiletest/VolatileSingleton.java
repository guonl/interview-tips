package com.guonl.thread.volatiletest;

/**
 * Created by guonl
 * Date 2018/4/3 下午2:43
 * Description: 测试volatile的原子性，以单例模式为例
 */
public class VolatileSingleton {

    private static volatile VolatileSingleton instance;

    public static VolatileSingleton getInstance(){
        if(instance == null){
            synchronized (VolatileSingleton.class){
                if (instance == null){
                    instance = new VolatileSingleton();
                }
            }
        }
        return instance;
    }

    /**
     * 这个单例模式看起来很完美，如果instance为空，则加锁，只有一个线程进入同步块
     完成对象的初始化，然后instance不为空，那么后续的所有线程获取instance都不用加锁，
     从而提升了性能。
     但是我们刚才讲了对象赋值操作步骤可能会存在重排序，
     即当前线程的步骤4执行到一半，其它线程如果进来执行到步骤1，instance已经不为null，
     因此将会读取到一个没有初始化完成的对象。
     但如果将instance用volatile来修饰，就完全不一样了，对instance的写入操作将会变成一个原子
     操作，没有初始化完，就不会被刷新到主存中。

     使用这种方式来修饰变量
     private static volatile VolatileSingleton instance;
     */

}

