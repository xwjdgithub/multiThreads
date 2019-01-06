package xwj;

public class Thread1 extends Thread {
    private String name;

    public Thread1(String name){
        this.name = name;
    }

    public void run(){
        for(int i=0; i<5; i++){
            System.out.println(name + "运行" + i);
            try {
                sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        Thread1 threadA = new Thread1("A");
        Thread1 thread1B = new Thread1("B");
        //注意不要直接调用ran方法，否则只能按顺序执行threadA和thread1B的run方法
        //即thread1A的run方法执行完毕后，才开始执行thread1B的run方法
//        threadA.run();
//        thread1B.run();
        threadA.start();
        thread1B.start();
    }

}
