package com.cyyaw.web.weborder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class CyyawWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyyawWebAppApplication.class, args);
    }

}
