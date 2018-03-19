package cn.zhangxd.platform.system.provider.proxy;

/**
 * @author zhangyongji
 * @since 2018/1/17.
 */
public class DynamicAndCglibTest {

    public static void main(String[] args) {
        DynamicOriginalClass doc = new DynamicOriginalClass();
        doc.testNoArgs();
        doc.testOneArgs("");
        System.out.println("====================");
        MyDynamicProxyClass myDynamicProxyClass = new MyDynamicProxyClass(doc);
        DynamicInterface dynamicInterface
                = (DynamicInterface) myDynamicProxyClass.getProxy();
        dynamicInterface.testNoArgs();
        dynamicInterface.testOneArgs("jiji");

        MyCglibProxyClass cglibProxyClass = new MyCglibProxyClass();
        SayHello sayHello
                = (SayHello) cglibProxyClass.getProxy(SayHello.class);
        sayHello.say();
    }
}
