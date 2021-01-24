package com.meow.logdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi //开启注解
public class LogdemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(LogdemoApplication.class, args);
        System.out.println("----------start success！！-----------");
        System.out.println("swagger3界面 http://localhost:8080/swagger-ui/");
        System.out.println("swagger更好看的界面  http://localhost:8080/doc.html");
    }

}
