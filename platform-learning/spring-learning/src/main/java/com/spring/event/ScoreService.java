package com.spring.event;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @author zhangyongji
 * @since 2018/9/28.
 */
@Configuration
public class ScoreService {

    @EventListener
    public void listenUserRegisterEvent(UserRegisterEvent userRegisterEvent) {
        System.out.println("积分服务接到通知，给 " + userRegisterEvent.getSource() + " 增加积分...");
    }
}
