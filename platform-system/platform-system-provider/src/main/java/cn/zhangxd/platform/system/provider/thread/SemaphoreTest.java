package cn.zhangxd.platform.system.provider.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyongji
 * @since 2018/1/14.
 * 参考URL: https://segmentfault.com/a/1190000008394155
 * <p>
 * 提问：10个用户去窗口买票，窗口只有两个，同时能买票的只有两个人，当两个人的其中一个离开，等待的人立即进入买票，即怎样同时控制某一时间并发数为2
 */
public class SemaphoreTest {

    class SemaporeRunnable implements Runnable {

        private Semaphore semaphore;
        private int user;

        public SemaporeRunnable(Semaphore semaphore, int user) {
            this.semaphore = semaphore;
            this.user = user;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("用户【" + user + "】进入窗口，开始买票。。。");
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println("用户【" + user + "】买票完成，离开窗口。。。");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void excute() {
        // 定义窗口数
        final Semaphore semaphore = new Semaphore(2);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        定义线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//        用户数
        for (int i = 0; i < 10; i++) {
            poolExecutor.execute(new SemaporeRunnable(semaphore, i + 1));
        }
        poolExecutor.shutdown();
    }

    public static void main(String[] args) {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        semaphoreTest.excute();
    }

}
