package com.example.spring.cloud.feign.person.service.provider.repository;

import com.example.spring.cloud.feign.person.service.provider.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * @Author: hanyf
 * @Description: {@link Person} 仓储
 * @Date: 2019/4/17 16:49
 */
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {


}
