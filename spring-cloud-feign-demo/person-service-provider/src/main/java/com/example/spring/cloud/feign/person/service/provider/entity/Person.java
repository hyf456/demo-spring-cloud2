package com.example.spring.cloud.feign.person.service.provider.entity;



import javax.persistence.*;

/**
 * @Author: hanyf
 * @Description:
 * @Date: 2019/4/17 14:57
 */
@Entity
@Table(name = "persons")
public class Person extends com.example.spring.cloud.feign.api.domain.Person {

    @Override
    @Id
    @GeneratedValue
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    @Column(columnDefinition = "VARCHAR(128) NOT NULL")
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
