package com.guonl.redisqueue;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.UUID;

/**
 * Created by guonl
 * Date 2018/4/20 下午3:24
 * Description: 模拟一个生产者
 */
public class TaskProducer implements Runnable{

    Jedis jedis = new Jedis("127.0.0.1",6379);

    @Override
    public void run() {
        Random random = new Random();
        while (true){
            try {
                Thread.sleep(random.nextInt(600) + 600);
                // 模拟生成一个任务
                UUID taskid = UUID.randomUUID();
                // 将任务插入任务队列，task-queue
                jedis.lpush("task-queue",taskid.toString());
                System.out.println("插入一个新的任务:" + taskid);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
