package com.jason.rat.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jason.rat.server.mapper")
public class RatServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatServerApplication.class, args);
    }

}
