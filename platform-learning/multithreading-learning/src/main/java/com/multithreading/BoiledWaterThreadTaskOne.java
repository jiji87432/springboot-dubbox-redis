package com.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyongji
 * @since 2019-05-21.
 */
public class BoiledWaterThreadTaskOne implements Callable {

    FutureTask futureTaskTwo;

    public BoiledWaterThreadTaskOne(FutureTask futureTaskTwo) {
        this.futureTaskTwo = futureTaskTwo;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("T1: 洗水壶......");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("T1: 烧开水......");
        TimeUnit.SECONDS.sleep(5);
        // 获取T2的茶叶
        String T2 = (String) futureTaskTwo.get();
        System.out.println("T1: 拿到T2加入的茶叶...." + T2);
        System.out.println("T1: 泡茶....");
        return "上茶:" + T2;
    }
}
