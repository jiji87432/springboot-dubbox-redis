package cn.zhangxd.platform.system.provider.jdk8lock;

public class NoReentrantLockTest {
    NoReentrantLock lock = new NoReentrantLock();

    public void print() throws InterruptedException {
        lock.lock();
        doAdd();
        lock.unlock();
    }

    public void doAdd() throws InterruptedException {
        lock.lock();
        //do something
        System.out.println("doAdd()");
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        NoReentrantLockTest noReentrantLockTest = new NoReentrantLockTest();
        noReentrantLockTest.print();
    }
}
