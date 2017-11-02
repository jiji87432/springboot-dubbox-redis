package cn.zhangxd.platform.system.provider.serviceimpl;

import cn.zhangxd.platform.common.redis.RedisRepository;
import cn.zhangxd.platform.common.redisson.DistributedLockUtil;
import cn.zhangxd.platform.common.service.service.CrudService;
import cn.zhangxd.platform.system.api.entity.TripUser;
import cn.zhangxd.platform.system.api.service.ITripUserService;
import cn.zhangxd.platform.system.provider.mapper.TripUserMapper;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务实现
 *
 * @author zhangxd
 */
@Service
@Transactional(readOnly = true)
public class TripUserService extends CrudService<TripUserMapper, TripUser> implements ITripUserService {

    private static RedissonClient redissonClient;

    @Autowired
    private RedisRepository redisRepository;

    /**
     * 使用config创建Redisson
     * Redisson是用于连接Redis Server的基础类
     *
     * @return
     */
    public static RedissonClient getRedisson() {
        RedissonClient redisson = Redisson.create();
        System.out.println("成功连接Redis Server");
        return redisson;
    }

    @Override
    public TripUser getByMobile(String mobile) {
        return getDao().getByMobile(mobile);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateInfo(TripUser tripUser) {
        tripUser.preUpdate();
        getDao().updateInfo(tripUser);
    }

    @Override
    @Transactional(readOnly = false)
    public void registryUser(String mobile, String password) {
        // 用户已存在不做处理，防止客户端重复提交
        // System.out.println("======" + redisRepository.exists(mobile));
        // if (redisRepository.exists(mobile)) {
        //     return;
        // } else {
        //     //插入用户信息
        //     redisRepository.set(mobile,mobile);
        //     TripUser user = new TripUser();
        //     user.preInsert();
        //     user.setMobile(mobile);
        //     user.setPassword(password);
        //     getDao().insert(user);
        // }
        // TripUser oldUser = getByMobile(mobile);
        // System.out.println("======并发写入前业务检查start=====");
        // if (oldUser != null) {
        //     System.out.println("======进入业务检查条件process=====");
        //     return;
        // }
        // System.out.println("======并发写入业务检查结束end=====");
        // 用户已存在不做处理，防止客户端重复提交
        // getDao().insert(user);
        // connects to 127.0.0.1:6379 by default
        // RedissonClient redisson = Redisson.create();
        // final RReadWriteLock lock = getRedisson().getReadWriteLock("lock");
        // final RLock writeLock = lock.writeLock();
        // new Thread() {
        //     @Override
        //     public void run() {
        //         writeLock.lock();
        //         try {
        //             System.out.println(Thread.currentThread().getName() + " setCash start");
        //             TripUser oldUser = getByMobile(mobile);
        //             System.out.println("======并发写入前业务检查start=====");
        //             if (oldUser != null) {
        //                 System.out.println("======进入业务检查条件process=====");
        //                 return;
        //             }
        //             System.out.println("======并发写入业务检查结束end=====");
        //             //插入用户信息
        //             TripUser user = new TripUser();
        //             user.preInsert();
        //             user.setMobile(mobile);
        //             user.setPassword(password);
        //             getDao().insert(user);
        //             Thread.sleep(1);
        //             System.out.println(Thread.currentThread().getName() + " setCash end");
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         } finally {
        //             writeLock.unlock();
        //         }
        //     }
        // }.start();
        try {
            DistributedLockUtil.lock(mobile);
            TripUser oldUser = getByMobile(mobile);
            System.out.println("======并发写入前业务检查start=====");
            if (oldUser != null) {
                System.out.println("======进入业务检查条件process=====");
                return;
            }
            System.out.println("======并发写入业务检查结束end=====");
            //插入用户信息
            TripUser user = new TripUser();
            user.preInsert();
            user.setMobile(mobile);
            user.setPassword(password);
            getDao().insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DistributedLockUtil.unlock(mobile);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void updatePasswordByMobile(String mobile, String password) {
        getDao().updatePasswordByMobile(mobile, password);
    }

    @Override
    @Transactional(readOnly = false)
    public void updatePhotoByUserId(String userId, String photo) {
        getDao().updatePhotoByUser(userId, photo);
    }

}
