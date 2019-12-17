package com.chat.messenger.lib;

public interface EventBus {
    void register(Object subscriber);
    void unRegister(Object subscriber);
    void post(Object event);
}
