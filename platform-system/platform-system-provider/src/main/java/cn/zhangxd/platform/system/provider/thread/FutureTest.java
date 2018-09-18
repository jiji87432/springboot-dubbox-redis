package cn.zhangxd.platform.system.provider.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangyongji
 * @since 2018/8/20.
 */
public class FutureTest {

    public static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("hahaha");
        }
    }

    public static class CallableTask implements Callable<AtomicInteger> {

        @Override
        public AtomicInteger call() throws Exception {
            System.out.println("hahaha");
            AtomicInteger atomicInteger = new AtomicInteger();
            for (int i = 0; i < 10; i++) {
                atomicInteger.incrementAndGet();
            }
            return atomicInteger;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
//        for (int i = 0; i < 10; i++) {
//            executor.submit(new Task());
//        }

        List<Future<AtomicInteger>> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            result.add(executor.submit(new CallableTask()));
        }

        for (Future<AtomicInteger> future : result) {
            System.out.println(future.get());
        }
    }
}
