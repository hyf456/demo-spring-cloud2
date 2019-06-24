package com.example.demo.web.controller;

import com.example.demo.stream.producer.MessageProducerBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hanyf
 * @Description: RabbitMQ 生产者
 * @Date: 2019/4/15 16:16
 */
@RestController
public class MessageProducerController {

    private final MessageProducerBean messageProducerBean;

    private final String topic;


    public MessageProducerController(MessageProducerBean messageProducerBean, @Value("${kafka.topic}") String topic) {
        this.messageProducerBean = messageProducerBean;
        this.topic = topic;
    }


    /**
     * 通过 {@link MessageProducerBean} 发送
     * @param message
     * @return
     */
    @GetMapping("/message/send")
    public Boolean send(@RequestParam String message) {
        messageProducerBean.send(message);
        return true;
    }

    /**
     * 通过 {@link MessageProducerBean} 发送
     * @param message
     * @return
     */
    @GetMapping("/message/send/to/gupao")
    public Boolean sendToGupao(@RequestParam String message) {
        messageProducerBean.sendToGupao(message);
        return true;
    }
}
