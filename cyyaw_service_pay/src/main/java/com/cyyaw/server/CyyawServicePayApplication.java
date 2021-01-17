package com.cyyaw.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 支付服务
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class CyyawServicePayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyyawServicePayApplication.class, args);
    }

}
