package com.example.demo.web.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: hanyf
 * @Description: Demo
 * @Date: 2019/4/16 15:27
 */
@RestController
public class DemoController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private final RestTemplate restTemplate;

    @Autowired
    public DemoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String index() {
        String returnValue = "Hello, World";
        logger.info("{} index() : {}", getClass().getSimpleName(), returnValue);
        return returnValue;
    }

    /**
     * 完整的调用链路了：
     * spring-cloud-sleuth
     *  -> zuul
     *      -> person-client
     *          -> person-service
     * @return
     */
    @GetMapping("/to/zuul/person-client/person/find/all")
    public Object toZuul() {
        logger.info("spring-cloud-sleuth # toZuul()");
        //spring-cloud-zuul    7070
        String url = "http://spring-cloud-zuul/person-client/person/find/all";
        Object forObject = restTemplate.getForObject(url, Object.class);
        return forObject;
    }
}
