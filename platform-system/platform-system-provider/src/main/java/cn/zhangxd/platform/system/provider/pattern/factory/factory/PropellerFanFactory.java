package cn.zhangxd.platform.system.provider.pattern.factory.factory;

import cn.zhangxd.platform.system.provider.pattern.factory.simple.ExhaustFan;
import cn.zhangxd.platform.system.provider.pattern.factory.simple.IFan;

/**
 * @author zhangyongji
 * @since 2019-03-04.
 */
public class PropellerFanFactory implements IFanFactory {
    @Override
    public IFan createFan() {
        return new ExhaustFan();
    }
}
