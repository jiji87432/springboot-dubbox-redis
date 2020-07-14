package cn.zhangxd.platform.system.provider.pattern.factory.factory;

import cn.zhangxd.platform.system.provider.pattern.factory.simple.CeilingFan;
import cn.zhangxd.platform.system.provider.pattern.factory.simple.IFan;

/**
 * @author zhangyongji
 * @since 2019-03-04.
 */
public class TableFanFactory implements IFanFactory {
    @Override
    public IFan createFan() {
        return new CeilingFan();
    }
}
