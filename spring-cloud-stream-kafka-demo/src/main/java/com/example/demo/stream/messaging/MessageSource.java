package com.example.demo.stream.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Author: hanyf
 * @Description:
 * @Date: 2019/4/16 9:19
 */
public interface MessageSource {

    /**
     * 消息来源的管道名称："gupao"
     */
    String GUPAO = "gupao";

    @Output(GUPAO)
    MessageChannel output();
}
