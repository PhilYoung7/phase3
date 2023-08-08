package com.woniuxy.operate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// @EnableAspectJAutoProxy
@EnableAspectJAutoProxy
@SpringBootApplication
public class OperateApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperateApplication.class,args);
    }

}