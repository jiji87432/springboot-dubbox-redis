package cn.zhangxd.platform.system.provider.singleton;

/**
 * @author zhangyongji
 * @since 2018/1/9.
 */
public class MySingleton {

    public enum MyEnumSingleton {
        INSTANCE;
        private MySingleton singleton;

        private MyEnumSingleton() {
            System.out.println("单例初始化");
            singleton = new MySingleton();
        }

        public MySingleton getInstance() {
            return singleton;
        }
    }

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        return MyEnumSingleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        MySingleton mySingleton1 = MySingleton.getInstance();
        MySingleton mySingleton2 = MySingleton.getInstance();
        System.out.println(mySingleton1 == mySingleton2);
    }

}
