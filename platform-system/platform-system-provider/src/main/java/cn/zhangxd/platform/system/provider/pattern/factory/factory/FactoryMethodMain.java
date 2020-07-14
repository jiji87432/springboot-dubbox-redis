package cn.zhangxd.platform.system.provider.pattern.factory.factory;

import cn.zhangxd.platform.system.provider.pattern.factory.simple.IFan;

/**
 * @author zhangyongji
 * @since 2019-03-04.
 */
public class FactoryMethodMain {
    public static void main(String[] args) {
        IFanFactory fanFactory = new PropellerFanFactory();
        IFan fan = fanFactory.createFan();
        fan.SwitchOn();
    }
}
