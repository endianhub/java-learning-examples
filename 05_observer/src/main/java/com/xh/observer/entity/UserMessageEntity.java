package com.xh.observer.entity;

import org.springframework.context.ApplicationEvent;

public class UserMessageEntity extends ApplicationEvent {
    private String email;
    private String phone;
    private String userId;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public UserMessageEntity(Object source) {
        super(source);
    }

    public UserMessageEntity(Object source, String email, String phone) {
        super(source);
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "email:" + email + ",phone:" + phone;
    }
}