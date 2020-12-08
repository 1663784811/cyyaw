package com.cyyaw.server.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 订单服务
 */
@EnableEurekaClient
@SpringBootApplication
public class CyyawServiceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyyawServiceOrderApplication.class, args);
    }

}
