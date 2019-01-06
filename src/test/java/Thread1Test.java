import xwj.Thread1;

public class Thread1Test {
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName() + "开始运行");
        Thread1 threadA = new Thread1("A");
        Thread1 thread1B = new Thread1("B");
        //注意不要直接调用ran方法，否则只能按顺序执行threadA和thread1B的run方法
        //即thread1A的run方法执行完毕后，才开始执行thread1B的run方法
//        threadA.run();
//        thread1B.run();
        threadA.start();
        thread1B.start();

        try{
            threadA.join();//调用join方法，主线程一直等到threadA运行结束才结束
        }catch (Exception e){
            e.printStackTrace();
        }

//        thread1B.join();


        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
