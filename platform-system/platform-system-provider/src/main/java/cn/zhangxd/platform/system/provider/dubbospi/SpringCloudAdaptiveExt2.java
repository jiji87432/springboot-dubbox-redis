package cn.zhangxd.platform.system.provider.dubbospi;

import com.alibaba.dubbo.common.URL;

public class SpringCloudAdaptiveExt2 implements AdaptiveExt2 {

    @Override
    public String echo(String msg, URL url) {
        return "spring cloud";
    }
}