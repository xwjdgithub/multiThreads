package xwj.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThread {

    public static void main(String args[]){
        ExecutorService mSingleThread = Executors.newSingleThreadScheduledExecutor();

        for(int i=0; i<7; i++){
            final int index = i+1;
            mSingleThread.execute(new Runnable() {
                public void run() {
                    System.out.println("现在时间：" + System.currentTimeMillis() + " 第" + index + "个线程：" + Thread.currentThread().getName());
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
