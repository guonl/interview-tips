package redis;

/**
 * Created by guonl
 * Date 2018/4/2 下午2:26
 * Description:
 */
public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.seckill();
    }
}
