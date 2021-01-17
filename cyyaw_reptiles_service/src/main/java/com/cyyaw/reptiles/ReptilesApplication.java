package com.cyyaw.reptiles;

import com.cyyaw.reptiles.table.entity.RTimer;
import com.cyyaw.reptiles.table.service.RTimerService;
import com.cyyaw.reptiles.thread.timer.TimerReptiles;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@EnableRabbit
@SpringBootApplication
@EnableScheduling
public class ReptilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReptilesApplication.class, args);
    }


    @Autowired
    private TimerReptiles timerReptiles;

    @Autowired
    RTimerService timerService;


    /**
     * 每隔30秒执行一次
     * 保存计时数据
     */
    @Scheduled(fixedRate = 10000)
    public void saveRTimerData() {
        List<RTimer> data = timerReptiles.getDate();
        if (null != data && data.size() > 0) {
            timerService.saveList(data);
        }
    }

}
