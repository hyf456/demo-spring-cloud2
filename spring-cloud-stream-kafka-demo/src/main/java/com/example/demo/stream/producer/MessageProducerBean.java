package com.example.demo.stream.producer;

import com.example.demo.stream.messaging.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;


/**
 * @Author: hanyf
 * @Description: 消息生产者
 * @Date: 2019/4/15 18:32
 */
@Component
@EnableBinding({Source.class, MessageSource.class})
public class MessageProducerBean {

    @Autowired
    @Qualifier(Source.OUTPUT) //Bean 名称
    private MessageChannel messageChannel;

    @Autowired
    private Source source;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    @Qualifier(MessageSource.GUPAO)
    private MessageChannel gupaoMessageChannel;

    /**
     * 发送消息
     * @param message 消息内容
     */
    public void send(String message) {
        // 通过消息管道发送消息
        // messageChannel.send(MessageBuilder.withPayload(message).build());
        source.output().send(MessageBuilder.withPayload(message).build());
    }

    /**
     * 发送消息
     * @param message 消息内容
     */
    public void sendToGupao(String message) {
        // 通过消息管道发送消息
        // gupaoMessageChannel.send(MessageBuilder.withPayload(message).build());
        messageSource.output().send(MessageBuilder.withPayload(message).build());
    }
}
