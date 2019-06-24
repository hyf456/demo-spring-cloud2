package com.example.spring.cloud.feign.api.hystrix;

import com.example.spring.cloud.feign.api.domain.Person;
import com.example.spring.cloud.feign.api.service.PersonService;

import java.util.Collection;
import java.util.Collections;

/**
 * {@link PersonService} Fallback实现
 * @Author: hanyf
 * @Description:
 * @Date: 2019/4/11 18:18
 */
public class PersonServiceFallback implements PersonService {
    @Override
    public boolean save(Person person) {
        return false;
    }

    @Override
    public Collection<Person> findAll() {
        return Collections.emptyList();
    }
}
