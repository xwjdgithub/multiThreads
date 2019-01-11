package xwj.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args){
        ExecutorService mFixedThreadPool = Executors.newFixedThreadPool(5);

        for(int i=0; i<7; i++){
            final int index = i+1;
            mFixedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println("时间：" + System.currentTimeMillis() + " 第" + index + "线程：" + Thread.currentThread().getName());
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
