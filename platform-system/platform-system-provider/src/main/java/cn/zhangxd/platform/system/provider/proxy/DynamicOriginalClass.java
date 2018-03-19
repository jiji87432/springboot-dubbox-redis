package cn.zhangxd.platform.system.provider.proxy;

public class DynamicOriginalClass implements DynamicInterface {

    @Override
    public void testNoArgs() {
        System.out.println("原始类中的testNoArgs方法");
    }

    @Override
    public String testOneArgs(String name) {
        System.out.println("原始类中的testOneArgs方法");
        return "原始类的testOneArgs返回值";
    }

}