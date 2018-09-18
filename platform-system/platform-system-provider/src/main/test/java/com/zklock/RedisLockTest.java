package com.zklock;

import cn.zhangxd.platform.system.provider.redislock.RedisLock;
import cn.zhangxd.platform.system.provider.redislock.ReentrantRedisLock;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RedisLockTest {

    @Test
    public void testGetDistributedLock() {
        String lockKey = "jiji_lock_test_key";
        String lockVal = "1234567890";
        boolean isLock = RedisLock.tryGetDistributedLock(lockKey, lockVal, 500);
        boolean isMLock = RedisLock.tryGetDistributedLock(lockKey, lockVal, 500);
//		boolean isReleaseLock = RedisLock.releaseDistributedLock(lockKey,lockVal);
        Assert.assertTrue(isLock);
        Assert.assertTrue(isMLock);
    }

    @Test
    public void testRealseDistributedLock() {
        String lockKey = "jiji_lock_test_key";
        String lockVal = UUID.randomUUID()
                             .toString();
        boolean isLock = RedisLock.releaseDistributedLock(lockKey, "");
        Assert.assertTrue(isLock);
    }

    @Test
    public void testGetLock() {
        String lockKey = "lock_test_key";
        String lockVal = "jiji1234567890";
        for (int i = 0; i < 2; i++) {
            String tmp = RedisLock.tryLock(lockKey, lockVal, 10, TimeUnit.SECONDS, 5);
            System.out.println(tmp);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        RedisLock.unlock(lockKey, lockVal);
        String tmp = RedisLock.tryLock(lockKey, lockVal, 10, TimeUnit.SECONDS, 5);
        System.out.println(tmp);
//        try {
//            Thread.currentThread()
//                  .join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    @Test
    public void testReentrantLock() {
        final String lockKey = "lock_test_key1";
        String tmp = ReentrantRedisLock.tryLock(lockKey, 10, TimeUnit.SECONDS, 5);
        System.out.println(tmp);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ReentrantRedisLock.tryLock(lockKey, 10, TimeUnit.SECONDS, 5);
        ReentrantRedisLock.tryLock(lockKey, 10, TimeUnit.SECONDS, 5);
        ReentrantRedisLock.tryLock(lockKey, 10, TimeUnit.SECONDS, 5);


        System.out.println("释放锁");
        ReentrantRedisLock.unlock(lockKey, tmp);
        ReentrantRedisLock.unlock(lockKey, tmp);
        ReentrantRedisLock.unlock(lockKey, tmp);

        for (int i = 0; i < 10; i++) {

            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    ReentrantRedisLock.tryLock(lockKey, 10, TimeUnit.SECONDS, 5);
                }
            });
            ;
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        ReentrantRedisLock.unlock(lockKey, tmp);


//		try {
//			Thread.currentThread().join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
    }

}
