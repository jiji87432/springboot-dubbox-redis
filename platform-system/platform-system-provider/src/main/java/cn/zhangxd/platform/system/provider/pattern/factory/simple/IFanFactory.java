package cn.zhangxd.platform.system.provider.pattern.factory.simple;

/**
 * @author zhangyongji
 * @since 2019-03-04.
 * <p>
 * refrence URL: https://www.codeproject.com/Articles/1131770/Factory-Patterns-Simple-Factory-Pattern
 */
public interface IFanFactory {
    public IFan createFan(FanType type);
}
