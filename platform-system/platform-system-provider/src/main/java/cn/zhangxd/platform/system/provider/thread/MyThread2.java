package cn.zhangxd.platform.system.provider.thread;

public class MyThread2 extends Thread//通过继承Thread类的方式
{
    String sign = "thread#2@";

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

}