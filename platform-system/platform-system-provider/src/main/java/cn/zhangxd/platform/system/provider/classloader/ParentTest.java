package cn.zhangxd.platform.system.provider.classloader;

/**
 * @author zhangyongji
 * @since 2018/8/13.
 */
public class ParentTest {


    static {
        System.out.println("init static parent static");
    }
    public ParentTest() {
        System.out.println("init parent constructor");
    }
}
