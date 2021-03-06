package com.zkl.taishou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@MapperScan("com.zkl.taishou.dao.*")
@ComponentScan("com.zkl.taishou.*")
@EnableJms
public class Taishou_Steward_App {

    public static void main(String[] args) {
        SpringApplication.run(Taishou_Steward_App.class,args);
    }
}
