package redis;

/**
 * Created by guonl
 * Date 2018/4/2 下午2:26
 * Description:
 */
public class Test {
    public static void main(String[] args) {
        Service service = new Service();
        for (int i = 0; i < 50; i++) {
            ThreadA threadA = new ThreadA(service);
            threadA.start();
        }
    }
}
