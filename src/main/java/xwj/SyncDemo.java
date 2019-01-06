package xwj;

/**
 * 线程同步示例，wait和ontify的使用
 * 功能，按照顺序交替打印出ABC，打印10次
 */
public class SyncDemo implements Runnable{

    private String name;
    private Object pre;
    private Object self;

    public SyncDemo(String name, Object pre, Object self){
        this.name = name;
        this.pre = pre;
        this.self = self;
    }

    public void run(){
        int count = 10;
        while (count > 0){
            synchronized (pre){//获取到对了pre对象锁，才开始执行
                synchronized (self){//获取到了self对象锁，才开始执行
                    System.out.print(this.name);
                    count--;

                    //两个作用：1、释放self对象锁（要等本线程执行完毕，才释放）
                    //2、唤醒正在等待self对象锁的其它对象，只唤醒一个
                    self.notify();
                }
                try{
                    //两个作用：1、释放pre对象锁，立即释放
                    //2、本线程（while循环）卡在此处，直到下次本线程被唤醒，从此处接着执行
                    pre.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] agrs){
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        SyncDemo syncDemoA = new SyncDemo("A", c, a);
        SyncDemo syncDemoB = new SyncDemo("B", a, b);
        SyncDemo syncDemoC = new SyncDemo("C", b, c);

        new Thread(syncDemoA).start();
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        new Thread(syncDemoB).start();
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(syncDemoC).start();
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
