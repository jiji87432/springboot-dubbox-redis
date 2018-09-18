package cn.zhangxd.platform.system.provider.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author zhangyongji
 * @since 2018/8/27.
 */
public class SPIDemoServiceTest {

    public static void main(String[] args) {
        ServiceLoader<DemoService> serviceLoader = ServiceLoader.load(DemoService.class);
        Iterator<DemoService> it = serviceLoader.iterator();
        while (it != null && it.hasNext()) {
            DemoService demoService = it.next();
            System.out.println("class:" + demoService.getClass()
                                                     .getName() + ":" + demoService.sayHi("World"));
        }
    }
}
