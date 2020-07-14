package cn.zhangxd.platform.system.provider.pattern.factory.factory;

import cn.zhangxd.platform.system.provider.pattern.factory.simple.IFan;

/**
 * @author zhangyongji
 * @since 2019-03-04.
 */
public class PropellerFan implements IFan {
    @Override
    public void SwitchOn() {
        System.out.println("PropellerFan on!");
    }

    @Override
    public void SwitchOff() {
        System.out.println("PropellerFan off!");
    }
}
