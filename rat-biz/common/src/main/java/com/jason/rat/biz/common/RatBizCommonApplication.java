package com.jason.rat.biz.common;

import com.jason.rat.biz.common.service.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class RatBizCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatBizCommonApplication.class, args);
    }

}
