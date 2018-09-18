package cn.zhangxd.platform.system.provider.jdk8lock;

/**
 * @author zhangyongji
 * @since 2018/8/16.
 */
public class VolitatileTest {

    public static volatile int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            for (int j = 0; j < 100; j++) {
                                count++;
                            }
                        }
                    }
            ).start();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(count);
    }
}
