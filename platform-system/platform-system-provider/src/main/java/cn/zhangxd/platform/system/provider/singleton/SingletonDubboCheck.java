package cn.zhangxd.platform.system.provider.singleton;

/**
 * @author zhangyongji
 * @since 2018/8/19.
 */
public class SingletonDubboCheck {

    private volatile static SingletonDubboCheck singletonDubboCheck = null;

    private SingletonDubboCheck() {
    }

    public static SingletonDubboCheck getInstance() {
        if (singletonDubboCheck == null) {
            synchronized (SingletonDubboCheck.class) {
                if (singletonDubboCheck == null) {
                    singletonDubboCheck = new SingletonDubboCheck();
                }
            }
        }
        return singletonDubboCheck;
    }
}
