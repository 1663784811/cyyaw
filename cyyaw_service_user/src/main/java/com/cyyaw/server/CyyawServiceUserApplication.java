package com.cyyaw.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 用户服务
 */
@EnableEurekaClient
@SpringBootApplication
public class CyyawServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyyawServiceUserApplication.class, args);
    }

}
