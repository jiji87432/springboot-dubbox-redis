package com.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhangyongji
 * @since 2019-05-21.
 */
public class BoiledWaterThreadMain {

    public static void main(String[] args) {
        FutureTask futureTaskTwo = new FutureTask(new BoiledWaterThreadTaskTwo());
        FutureTask futureTaskOne = new FutureTask(new BoiledWaterThreadTaskOne(futureTaskTwo));

        Thread threadOne = new Thread(futureTaskOne);
        threadOne.start();

        Thread threadTwo = new Thread(futureTaskTwo);
        threadTwo.start();

        try {
            System.out.println(futureTaskOne.get()
                                            .toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
