package com.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author jiji
 */
public class UserRegisterEvent extends ApplicationEvent {

    public UserRegisterEvent(String name) {
        super(name); //name即source
    }

}