package com.example.demo.stream.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: hanyf
 * @Description: 消息消费Bean
 * @Date: 2019/4/16 10:44
 */
@Component
@EnableBinding({Sink.class})
public class MessageConsumerBean {

    @Autowired
    @Qualifier(Sink.INPUT) //Bean 名称
    private SubscribableChannel subscribableChannel;

    @Autowired
    private Sink sink;

    /**
     * 当字段注入完成后的回调
     */
    @PostConstruct
    public void init() {
        // 实现异步回调
        subscribableChannel.subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {

                System.out.println("subscribe : " + message.getPayload());

            }
        });
    }

    /**
     * 通过 @ServiceActivator
     */
    @ServiceActivator(inputChannel = Sink.INPUT)
    public void onMessage(Object message) {
        System.out.println("onMessage : " + message);
    }

    /**
     * 通过 @@StreamListener 订阅消息
     */
    @StreamListener(Sink.INPUT)
    public void onMessage(String message) {
        System.out.println("@StreamListener : " + message);
    }
}
