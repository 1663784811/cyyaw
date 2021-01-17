package com.cyyaw.reptiles.rabbitmq;

import com.cyyaw.reptiles.thread.ThreadMain;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue(value = "rabbit001"))
public class RabbitmqService {

    @Autowired
    private ThreadMain threadMain;

    @RabbitHandler
    public void receive(String message) {
        threadMain.run(message);
    }
}
