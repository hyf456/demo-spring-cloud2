package com.example.spring.cloud.feign.person.service.provider.web.controller;

import com.example.spring.cloud.feign.api.domain.Person;
import com.example.spring.cloud.feign.api.service.PersonService;
import com.example.spring.cloud.feign.person.service.provider.repository.PersonRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@link PersonService} 提供者控制器 (可选实现{@link PersonService}
 * @Author: hanyf
 * @Description:
 * @Date: 2019/4/10 15:16
 */
@RestController
public class PersonServiceProviderController {

    private Map<Long, Person> personMap = new ConcurrentHashMap<>();

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    private final static Random random = new Random();

    /**
     * 功能描述 保存
     * @author hanyf
     * @date 2019/4/10 15:19
     * @param person
     * @return boolean <code>true</code>
     */
    @PostMapping(value = "/person/save")
    public boolean savePerson(@RequestBody Person person) {
        return personMap.put(person.getId(), person) == null;
    }

    /**
     * 功能描述 查找所有的服务
     * @author hanyf
     * @date 2019/4/10 14:36
     * @param
     * @return java.util.Collection<com.example.spring.cloud.feign.api.domain.Person>
     */
    @GetMapping(value = "/person/find/all")
    @HystrixCommand(fallbackMethod = "errorContent",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
    })
    Collection<Person> findAll() throws Exception {
        //如果随机时间大于100，那么触发容错
        int value = random.nextInt(200);
        System.out.println("findAll() costs" + value + "ms.");
        Thread.sleep(value);
        return personMap.values();
    }

    /**
     * 功能描述 {@link #findAll()} Fallback方法
     * @author hanyf
     * @date 2019/4/12 16:11
     * @param
     * @return java.util.Collection<com.example.spring.cloud.feign.api.domain.Person>
     */
    public Collection<Person> fallbackForFindAllPersons() {
        return Collections.emptyList();
    }

    @GetMapping("/person/list")
    public Page<com.example.spring.cloud.feign.person.service.provider.entity.Person> list(Pageable pageable) {
        return personRepository.findAll(pageable);
    }
}
