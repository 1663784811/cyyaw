package com.cyyaw.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单服务
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class CyyawServiceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyyawServiceOrderApplication.class, args);
    }

}
