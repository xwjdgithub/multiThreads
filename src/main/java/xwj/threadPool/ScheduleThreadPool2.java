package xwj.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPool2 {
    public static void main(String[] args){
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);
        System.out.println("现在时间：" +  System.currentTimeMillis());

        scheduledExecutor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("现在时间：" +  System.currentTimeMillis());
            }
        }, 2, 4, TimeUnit.SECONDS);//延迟两秒后每隔4秒执行一次
    }
}
