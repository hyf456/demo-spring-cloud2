package com.example.spring.cloud.feign.web.controller;

import com.example.spring.cloud.feign.api.domain.Person;
import com.example.spring.cloud.feign.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * {@link PersonClientController} 实现 {@link PersonService}
 * @Author: hanyf
 * @Description:
 * @Date: 2019/4/10 14:52
 */
@RestController
public class PersonClientController implements PersonService {

    private final PersonService personService;
    @Autowired
    public PersonClientController(PersonService personService) {
        this.personService = personService;
    }


    @Override
    public boolean save(@RequestBody Person person) {
        return personService.save(person);
    }

    @Override
    public Collection<Person> findAll() {
        return personService.findAll();
    }
}
