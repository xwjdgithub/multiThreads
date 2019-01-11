package xwj.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args){
        ExecutorService mCachedThreadPool = Executors.newCachedThreadPool();

        for(int i=0; i<7; i++){
            final int index = i;
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            mCachedThreadPool.execute(new Runnable() {
                public void run() {
                    //线程sleep2秒，未超时（60秒），则第一次新建的线程一直被复用，执行全部的7次任务
                    System.out.println("第" +  index + "个线程：" + Thread.currentThread().getName());
                }
            });
        }
    }

}
