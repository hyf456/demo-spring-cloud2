package com.example.demo.raw.api;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: hanyf
 * @Description: Kafka Producer Demo(使用原始PAI）
 * @Date: 2019/4/15 15:34
 */
public class KafkaProducerDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //初始化配置
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "loalhost:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        // 创建 Kafka Producer
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);

        String topic = "gupao";
        Integer partition = 0;
        Long timestamp = System.currentTimeMillis();
        String key = "message-key";
        String value = "小马哥";
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, partition, timestamp, key, value);
        // 发送 Kafka 消息
        Future<RecordMetadata> metadataFuture = kafkaProducer.send(record);
        // 强制执行
        metadataFuture.get();
    }
}
