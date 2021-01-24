package com.meow.logdemo.service.impl;

import com.meow.logdemo.bean.Person;
import com.meow.logdemo.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * Person Service实现
 */
@Service
public class PersonServiceImpl implements PersonService {

    /**
     * add Person
     * @param person
     * @return
     */
    @Override
    public String savePerson(Person person) {
        //todo 模拟新增。。。。。。
        System.out.println("--------------add by mysql/oracle .... start---------");
        System.out.println("add data :" + person.toString());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------add by mysql/oracle .... end---------");
        return "add success!!!";
    }
}
