package com.mybatis;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyongji
 * @since 2018/9/28.
 */
@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/testaTob")
    public String register() throws HttpProcessException {
        //最简单的使用：
        System.out.println("B->A");
        String resp = HttpClientUtil.get(HttpConfig.custom().url("http://127.0.0.1:8080/testbToa"));
        return "testbToa";
    }
}
