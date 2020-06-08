package com.taishou.console;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/6/2-16:36
 * @Version:
 */
@SpringBootApplication
@MapperScan("com.taishou.console.dao")
@ComponentScan("com.taishou.console.*")
@EnableJms
public class Taishou_Console_Initiator {

    public static void main(String[] args) {
        SpringApplication.run(Taishou_Console_Initiator.class,args);
    }
}
