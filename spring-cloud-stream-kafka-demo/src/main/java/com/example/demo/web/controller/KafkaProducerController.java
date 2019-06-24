package com.example.demo.web.controller;

import com.example.demo.stream.producer.MessageProducerBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hanyf
 * @Description: Kafka 生产者
 * @Date: 2019/4/15 16:16
 */
@RestController
public class KafkaProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final MessageProducerBean messageProducerBean;

    private final String topic;


    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate,
                                   MessageProducerBean messageProducerBean, @Value("${kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.messageProducerBean = messageProducerBean;
        this.topic = topic;
    }

    /**
     * 通过 Kafka Template 发送
     * @param message
     * @return
     */
    @PostMapping("/message/send")
    public Boolean sendMessage(@RequestParam String message) {
        kafkaTemplate.send(topic, message);
        return true;
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
