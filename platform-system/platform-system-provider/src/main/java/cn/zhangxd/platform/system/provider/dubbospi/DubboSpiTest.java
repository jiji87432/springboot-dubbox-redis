package cn.zhangxd.platform.system.provider.dubbospi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * @author zhangyongji
 * @since 2018/8/28.
 */
public class DubboSpiTest {

    @Test
    public void test1() {
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test");
        URL url2 = URL.valueOf("test://localhost/test?t=cloud");
//        URL url3 = URL.valueOf("test://localhost/test?adaptive.ext2=thrift");
        System.out.println(adaptiveExtension.echo("d", url));
        System.out.println(adaptiveExtension.echo("d", url2));
//        System.out.println(adaptiveExtension.echo("d", url3));
    }
}
