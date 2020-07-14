package cn.zhangxd.platform.system.provider.pattern.factory;

/**
 * @author zhangyongji
 * @since 2019-03-04.
 */
public class TableFan implements IFan {
    @Override
    public void SwitchOn() {
        System.out.println("TableFan on!");
    }

    @Override
    public void SwitchOff() {
        System.out.println("TableFan off!");
    }
}
