package com.multithreading;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorExample {

    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(3,
                3,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );

//        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(3);

        class S1Task implements Callable<String> {
            @Override
            public String call() throws Exception {
                return "getPriceByS1()";
            }
        }

        class S2Task implements Callable<String> {
            @Override
            public String call() throws Exception {
                return "getPriceByS2()";
            }
        }

        class S3Task implements Callable<String> {
            @Override
            public String call() throws Exception {
                return "getPriceByS3()";
            }
        }

        class SaveTask implements Callable<Boolean> {
            private List<FutureTask<String>> futureTasks;

            public SaveTask(List<FutureTask<String>> futureTasks) {
                this.futureTasks = futureTasks;
            }

            @Override
            public Boolean call() throws Exception {
                for (FutureTask<String> futureTask : futureTasks) {
                    String data = futureTask.get(10, TimeUnit.SECONDS);
                    System.out.println("询问到的价格=" + data);
                    System.out.println("数据" + data + "入库");
                }
                return Boolean.TRUE;
            }
        }

        S1Task s1Task = new S1Task();
        FutureTask<String> st1 = new FutureTask<>(s1Task);
        S2Task s2Task = new S2Task();
        FutureTask<String> st2 = new FutureTask<>(s2Task);
        S3Task s3Task = new S3Task();
        FutureTask<String> st3 = new FutureTask<>(s3Task);
        List<FutureTask<String>> futureTasks = Lists.<FutureTask<String>>newArrayList(st1, st2, st3);
        FutureTask<Boolean> saveTask = new FutureTask<>(new SaveTask(futureTasks));
        threadPoolExecutor.submit(st1);
        threadPoolExecutor.submit(st2);
        threadPoolExecutor.submit(st3);
        threadPoolExecutor.submit(saveTask);
    }
}