package cn.zhangxd.platform.system.provider.thread;

import java.util.concurrent.*;

/**
 * @author zhangyongji
 * @since 2018/1/14.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        // 定义线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("来了先去拍照留念");
            }
        });
        for (int i = 0; i < 3; i++) {
            final int user = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(user + "到达聚餐地点，当前已有" + (cyclicBarrier.getNumberWaiting() + 1) + "个人");
                        cyclicBarrier.await();
                        System.out.println("拍照结束，开始吃饭了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };
            poolExecutor.execute(runnable);
        }
        poolExecutor.shutdown();
    }
}
