package cn.zhangxd.platform.system.provider.dubbospi;

import com.alibaba.dubbo.common.URL;

//@Adaptive
public class ThriftAdaptiveExt2 implements AdaptiveExt2 {

    @Override
    public String echo(String msg, URL url) {
        return "thrift";
    }
}