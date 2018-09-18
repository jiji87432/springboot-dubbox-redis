package cn.zhangxd.platform.system.provider.jdk8lock;

/**
 * 当前线程执行print()方法首先获取lock，
 * 接下来执行doAdd()方法就无法执行doAdd()中的逻辑，
 * 必须先释放锁。这个例子很好的说明了不可重入锁。
 */
public class NoReentrantLock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
