package com.cyyaw.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 页面服务
 */


@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class CyyawServiceSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyyawServiceSsoApplication.class, args);
    }

}
