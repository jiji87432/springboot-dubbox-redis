package cn.zhangxd.platform.system.provider.spi;

public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHi(String msg) {

        return "Hello, " + msg;
    }

}