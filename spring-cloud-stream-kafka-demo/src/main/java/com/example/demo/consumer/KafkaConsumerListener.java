package com.example.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author: hanyf
 * @Description: Kafka 消费者监听器
 * @Date: 2019/4/15 16:27
 */
@Component
public class KafkaConsumerListener {

    @KafkaListener(topics = "${kafka.topic}")
    public void onMessage(String message) {
        System.out.println("Kafka 消费者监听器, 接收到消息:" + message);
    }

    @KafkaListener(topics = "gupao")
    public void onGupaoMessage(String message) {
        System.out.println("Kafka 消费者监听器, 接收到消息:" + message);
    }
}
