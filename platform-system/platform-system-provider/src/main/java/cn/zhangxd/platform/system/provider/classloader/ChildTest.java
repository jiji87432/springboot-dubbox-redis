package cn.zhangxd.platform.system.provider.classloader;

/**
 * @author zhangyongji
 * @since 2018/8/13.
 */
public class ChildTest extends ParentTest {

    static {
        System.out.println("init child static");
    }

    public static String testClassLoader(){
        System.out.println("static function classLoader test start");
        return "jiji";
    }

    public ChildTest() {
        System.out.println("init child constructor");
    }

    public void testClassLocader(){
        System.out.println("classLoader test start ");
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        ChildTest childTest = new ChildTest();
//        childTest.testClassLocader();
//        ChildTest.testClassLoader();
        Class classtest = Class.forName("cn.zhangxd.platform.system.provider.classloader.ChildTest");
    }
}
