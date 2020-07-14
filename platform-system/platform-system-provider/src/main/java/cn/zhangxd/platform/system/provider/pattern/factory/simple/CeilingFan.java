package cn.zhangxd.platform.system.provider.pattern.factory;

/**
 * @author zhangyongji
 * @since 2019-03-04.
 */
public class CeilingFan implements IFan {
    @Override
    public void SwitchOn() {
        System.out.println("CeilingFan on!");
    }

    @Override
    public void SwitchOff() {
        System.out.println("CeilingFan on!");
    }
}
