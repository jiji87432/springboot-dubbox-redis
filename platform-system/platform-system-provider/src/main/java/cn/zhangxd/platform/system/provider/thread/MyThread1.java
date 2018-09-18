package cn.zhangxd.platform.system.provider.thread;

public class MyThread1 implements Runnable//通过实现Runnable接口方式
{
    String sign = "thread#1@";

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(sign + "->" + i);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        // 通过主线程启动自己的线程

        // 通过实现runnable接口
//        Runnable myThread1 = new MyThread1();
//        Thread thread1 = new Thread(myThread1);
//        thread1.start();

        // 通过继承thread类
//        Thread thread2 = new Thread(new MyThread2());
//        thread2.start();

        // 注意这里不是调运run()方法，而是调运线程类Thread的start方法，在Thread方法内部，会调运本地系统方法，最终会自动调运自己线程类的run方法

        // 让主线程睡眠
//        Thread.sleep(1000L);
//        System.out.println("主线程结束！用时："
//                + (System.currentTimeMillis() - startTime));
        // System.exit(0);

        Runnable myThread1 = new MyThread1();
        Thread thread1 = new Thread(myThread1);
        thread1.setDaemon(true);
        thread1.start();

        Thread thread2 = new Thread(new MyThread2());
        thread2.setDaemon(false);
        thread2.start();

        System.out.println("mainThread isDaemon:"
                + Thread.currentThread().isDaemon());
        System.out.println("thread1 isDaemon:" + thread1.isDaemon());
        System.out.println("thread2 isDaemon:" + thread2.isDaemon());
    }

}