package com.meow.logdemo.controller;

import com.meow.logdemo.annotation.LogAnn;
import com.meow.logdemo.bean.Person;
import com.meow.logdemo.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Person Controller
 */
@Controller
@RequestMapping("person")
@Api(value = "person test controller（类描述）")
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * add Person
     * @param person
     */
    @Operation(summary = "我是保存用户的接口（方法描述）") //参数描述 隐藏接口之类的。。。。。
    @LogAnn(moduleName = "用户菜单", buttonName = "新增用户") //记录日志
    @RequestMapping("savePerson")
    @ResponseBody
    public String savePerson(Person person){
        return personService.savePerson(person);
    }
}
