package com.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyongji
 * @since 2019-05-21.
 */
public class BoiledWaterThreadTaskTwo implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("T2: 洗茶壶...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("T2: 洗茶杯...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("T2: 拿茶叶...");

        return "龙井";
    }
}
