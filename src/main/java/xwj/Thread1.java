package xwj;

public class Thread1 extends Thread {
    private String name;

    public Thread1(String name){
        this.name = name;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + "开始运行");
        for(int i=0; i<5; i++){
            System.out.println(name + "运行" + i);
            try {
                sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

}
