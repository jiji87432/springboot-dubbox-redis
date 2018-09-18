package cn.zhangxd.platform.system.provider.scheduled;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiji
 */
@Configuration
public class TestJavaConfigBean {

    @Value("${timeout:100}")
    private int timeout;
    @Value("${batch:200}")
    private int batch;
    @Value("${staticKey:jiji}")
    private static String staticKey;

}
