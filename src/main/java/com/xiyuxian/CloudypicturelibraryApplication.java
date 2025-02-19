package com.xiyuxian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.xiyuxian.mapper")
public class CloudypicturelibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudypicturelibraryApplication.class, args);
    }

}
