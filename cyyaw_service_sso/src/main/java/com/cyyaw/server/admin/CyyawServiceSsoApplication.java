package com.cyyaw.server.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 页面服务
 */
@EnableEurekaClient
@SpringBootApplication
public class CyyawServiceSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyyawServiceSsoApplication.class, args);
    }

}
