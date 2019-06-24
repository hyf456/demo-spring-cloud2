package com.example.spring.cloud.feign.api.service;

import com.example.spring.cloud.feign.api.domain.Person;
import com.example.spring.cloud.feign.api.hystrix.PersonServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * {@link Person} 服务
 * @Author: hanyf
 * @Description:
 * @Date: 2019/4/10 14:30
 */
@FeignClient(value = "person-service", fallback = PersonServiceFallback.class)//服务提供方应用的名称
public interface PersonService {

    /**
     * 功能描述 保存
     * @author hanyf
     * @date 2019/4/10 14:35
     * @param person
     * @return boolean 如果成功,<code>true</code>
     */
    @PostMapping(value = "/person/save")
    boolean save(@RequestBody Person person);

    /**
     * 功能描述 查找所有的服务
     * @author hanyf
     * @date 2019/4/10 14:36
     * @param
     * @return java.util.Collection<com.example.spring.cloud.feign.api.domain.Person>
     */
    @GetMapping(value = "/person/find/all")
    Collection<Person> findAll();
}
