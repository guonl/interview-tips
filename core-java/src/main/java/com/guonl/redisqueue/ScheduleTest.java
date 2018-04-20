package com.guonl.redisqueue;

/**
 * Created by guonl
 * Date 2018/4/20 下午3:57
 * Description:
 */
public class ScheduleTest {

    public static void main(String[] args) throws InterruptedException {
        // 启动一个生产者线程，模拟任务的生产
        new Thread(new TaskProducer()).start();

        Thread.sleep(15000);

        // 启动一个client线程，模拟任务的处理
        new Thread(new TaskConsumer()).start();

        // 主线程休眠
        Thread.sleep(Long.MAX_VALUE);
    }
}
