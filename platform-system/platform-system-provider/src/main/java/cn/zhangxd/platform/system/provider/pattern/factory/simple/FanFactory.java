package cn.zhangxd.platform.system.provider.pattern.factory.simple;

/**
 * @author zhangyongji
 * @since 2019-03-04.
 */
public class FanFactory implements IFanFactory {
    @Override
    public IFan createFan(FanType type) {
        switch (type) {
            case TableFan:
                return new TableFan();
            case CeilingFan:
                return new CeilingFan();
            case ExhaustFan:
                return new ExhaustFan();
            default:
                return new TableFan();
        }
    }

    public static void main(String[] args) {
        IFanFactory simpleFactory = new FanFactory();
        // Creation of a Fan using Simple Factory
        IFan fan = simpleFactory.createFan(FanType.TableFan);
        // Use created object
        fan.SwitchOn();
    }
}
