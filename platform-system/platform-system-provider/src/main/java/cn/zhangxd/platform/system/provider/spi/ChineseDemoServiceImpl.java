package cn.zhangxd.platform.system.provider.spi;

public class ChineseDemoServiceImpl implements DemoService {

    @Override
    public String sayHi(String msg) {

        return "你好, "+msg;
    }

}