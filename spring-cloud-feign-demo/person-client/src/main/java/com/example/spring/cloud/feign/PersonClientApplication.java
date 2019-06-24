package com.example.spring.cloud.feign;

import com.example.spring.cloud.feign.api.service.PersonService;
import com.example.spring.cloud.feign.api.web.WebConfig;
import com.example.spring.cloud.feign.client.ribbon.FirstServerForeverRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Author: hanyf
 * @Description:
 * @Date: 2019/4/10 14:50
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = PersonService.class)
@ComponentScan("com.example")
@RibbonClient(value = "person-service", configuration = PersonClientApplication.class)
@EnableHystrix
@Import(WebConfig.class)
public class PersonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class, args);
    }

    @Bean
    public FirstServerForeverRule firstServerForeverRule() {
        return new FirstServerForeverRule();
    }
}
