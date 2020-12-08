package com.cyyaw.spring.bootadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableAdminServer
@EnableEurekaClient
@SpringBootApplication
public class SpringBootadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootadminApplication.class, args);
    }

}
