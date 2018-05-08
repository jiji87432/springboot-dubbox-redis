package cn.zhangxd.platform.system.provider.scheduled;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * @author zhangyongji
 * @since 2018/4/9.
 */

@Configuration
@EnableScheduling
public class ApolloAutoUpdate {

    public final static long TEN_SECOND = 20 * 1000;

    @Resource
    private TestJavaConfigBean testJavaConfigBean;

    /**
     * fixedRate就是每多少分钟一次，不论你业务执行花费了多少时间,我都是1分钟执行1次
     */
    @Scheduled(fixedRate = TEN_SECOND)
    public void fixedRateJob() {
        System.out.println("==== 定时器测试apollo自动更新 ====,当前时间：" + System.currentTimeMillis());
        System.out.println("==== 定时器测试apollo自动更新Batch ====：" + testJavaConfigBean.getBatch());
        System.out.println("==== 定时器测试apollo自动更新Timeout ====：" + testJavaConfigBean.getTimeout());
        System.out.println("==== 定时器测试apollo自动更新SomeDate ====：" + testJavaConfigBean.getSomeDate());
    }

}
