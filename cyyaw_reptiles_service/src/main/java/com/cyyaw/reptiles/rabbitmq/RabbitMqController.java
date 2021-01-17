package com.cyyaw.reptiles.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rabbitmq")
@RestController
public class RabbitMqController {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("/publishMessage")
    public String publishMessage(String message){

        rabbitTemplate.convertAndSend("rabbit001", message);

        return "ok";
    }



}
