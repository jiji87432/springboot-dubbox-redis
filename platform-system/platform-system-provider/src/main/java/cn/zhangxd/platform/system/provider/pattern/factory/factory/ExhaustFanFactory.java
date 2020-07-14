package cn.zhangxd.platform.system.provider.pattern.factory.factory;

import cn.zhangxd.platform.system.provider.pattern.factory.simple.IFan;
import cn.zhangxd.platform.system.provider.pattern.factory.simple.TableFan;

/**
 * @author zhangyongji
 * @since 2019-03-04.
 */
public class ExhaustFanFactory implements IFanFactory {
    @Override
    public IFan createFan() {
        return new TableFan();
    }
}
