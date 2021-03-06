package com.cyyaw.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class CyyawServiceGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyyawServiceGoodsApplication.class, args);
    }

}
