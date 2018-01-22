package cn.zhangxd.platform.system.provider.thread;

public class TestMainChild extends Thread {
    @Override
    public void run() {
        Thread sonthread = new Sonthread();
        sonthread.start();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread fatherThread = new TestMainChild();
        fatherThread.start();
        Thread.sleep(5000);
        fatherThread.interrupt();
        Thread.sleep(2000);
        System.out.println("fatherThread.isAlive()?  " + fatherThread.isAlive());
    }
}

class Sonthread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我还活着");
        }
    }
}