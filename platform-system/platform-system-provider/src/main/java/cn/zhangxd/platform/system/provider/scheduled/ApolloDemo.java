package cn.zhangxd.platform.system.provider.scheduled;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangyongji
 * @since 2018/6/6.
 */
@Configuration
public class ApolloDemo {
    @Value("${timeout:100}")
    private int timeout;
    @Value("${batch:100}")
    private int batch;
    private static String staticKey;

    @Value("${staticKey}")
    public static void setStaticKey(String staticKey) {
        ApolloDemo.staticKey = staticKey;
    }

    public static String getStaticKey() {
        return staticKey;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }
}
