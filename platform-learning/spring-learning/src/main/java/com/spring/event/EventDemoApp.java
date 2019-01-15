package com.spring.event;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EventDemoApp {
    public static void main(String[] args) {
        SpringApplication.run(EventDemoApp.class, args);
    }



    @Autowired
    UserService userService;
    @RequestMapping("/register")
    public String register(){
        userService.register("kirito");
        return "success";
    }

    @RequestMapping("/testbToa")
    public String test() throws HttpProcessException {
        System.out.println("A->B");
        String resp = HttpClientUtil.get(HttpConfig.custom().url("http://10.240.33.55:8080/testaTob"));
        return "testaTob";
    }
}