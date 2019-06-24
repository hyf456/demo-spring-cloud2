package com.example.spring.cloud.feign.person.service.provider.service;

import com.example.spring.cloud.feign.person.service.provider.entity.Person;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @Author: hanyf
 * @Description: {@link Person} 服务
 * @Date: 2019/4/17 15:24
 */
@Service
@Transactional
public class PersonService {

    /**
     * 通过标准的 JPA 的方式注入
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 存储 {@link Person}
     * @param person
     */
    public void save(Person person) {
        entityManager.persist(person);
    }
}
