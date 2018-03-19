package cn.zhangxd.platform.system.provider.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangyongji
 * @since 2018/1/17.
 */
public class MyDynamicProxyClass implements InvocationHandler {

    private Object object;

    public MyDynamicProxyClass(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理方法加入前置操作");
        Object result = method.invoke(object, args);
        System.out.println("动态代理方法加入后置操作");
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread()
                                            .getContextClassLoader(), object.getClass()
                                                                            .getInterfaces(), this);
    }
}
