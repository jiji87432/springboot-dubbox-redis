package cn.zhangxd.platform.system.provider.scheduled;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author jiji
 */
@Configuration
public class TestJavaConfigBean {

    @Value("${timeout:100}")
    private int timeout;
    private int batch;
    @Value("#{new java.text.SimpleDateFormat('${dateFormat}').parse('${dateProperty}')}")
    private Date someDate;

    @Value("${batch:200}")
    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getBatch() {
        return batch;
    }

    public Date getSomeDate() {
        return someDate;
    }
}
