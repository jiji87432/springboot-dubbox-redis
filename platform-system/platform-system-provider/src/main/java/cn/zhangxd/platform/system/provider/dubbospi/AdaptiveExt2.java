package cn.zhangxd.platform.system.provider.dubbospi;

import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

import com.alibaba.dubbo.common.URL;

@SPI("dubbo")
public interface AdaptiveExt2 {
    @Adaptive({"t"})
    String echo(String msg, URL url);
}