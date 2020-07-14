package cn.zhangxd.platform.system.provider.pattern.factory.simple;

/**
 * @author zhangyongji
 * @since 2019-03-04.
 */
public class ExhaustFan implements IFan {
    @Override
    public void SwitchOn() {
        System.out.println("ExhaustFan on!");
    }

    @Override
    public void SwitchOff() {
        System.out.println("ExhaustFan on!");
    }
}
