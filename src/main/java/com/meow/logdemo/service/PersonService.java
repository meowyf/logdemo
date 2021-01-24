package com.meow.logdemo.service;

import com.meow.logdemo.bean.Person;

/**
 * Person interface
 */
public interface PersonService {

    /**
     * add Person
     * @param person
     * @return
     */
    String savePerson(Person person);
}
