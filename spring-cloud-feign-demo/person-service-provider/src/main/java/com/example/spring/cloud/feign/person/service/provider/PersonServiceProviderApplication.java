package com.example.spring.cloud.feign.person.service.provider;

import com.example.spring.cloud.feign.api.service.PersonService;
import com.example.spring.cloud.feign.api.web.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * {@link PersonService} 提供者应用
 * @Author: hanyf
 * @Description:
 * @Date: 2019/4/10 15:15
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@Import(WebConfig.class)
@EnableTransactionManagement(proxyTargetClass = true)
public class PersonServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceProviderApplication.class, args);
    }
}
