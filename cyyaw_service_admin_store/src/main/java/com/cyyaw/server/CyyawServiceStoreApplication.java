package com.cyyaw.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 订单服务
 */
@EnableEurekaClient
@SpringBootApplication
public class CyyawServiceStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyyawServiceStoreApplication.class, args);
    }

}
