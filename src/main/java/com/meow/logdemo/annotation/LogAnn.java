package com.meow.logdemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义log日志注解
 */
@Target(ElementType.METHOD) // 方法级注解
@Retention(RetentionPolicy.RUNTIME) // 运行时
public @interface LogAnn {

    //模块名称
    String moduleName();

    //按钮名称
    String buttonName();

    //todo 菜单名字 。。。

}
