package com.cyyaw.reptiles.thread.timer;

import com.cyyaw.common.util.DateUtils;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.reptiles.table.entity.RTimer;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 爬取计时器
 */
@Component
public class TimerReptiles implements Timer<RTimer> {

    private volatile static Map<String, Map<String, RTimer>> map = new ConcurrentHashMap<>();

    @Override
    public void count() {
        Date date = new Date();
        String minute = DateUtils.getStringDate(date, "yyyy-MM-dd HH:mm");
        String second = DateUtils.getStringDate(date, "yyyy-MM-dd HH:mm:ss");
        Map<String, RTimer> data = map.get(minute);
        if (null == data) {
            data = new ConcurrentHashMap<>();
        }
        RTimer rTimer = data.get(second);
        if (null == rTimer) {
            rTimer = new RTimer();
            rTimer.setTid(StringUtilWHY.getUUID());
            rTimer.setRtime(date);
            rTimer.setSpeed(0);
        }
        rTimer.setSpeed(rTimer.getSpeed() + 1);
        data.put(second, rTimer);
        map.put(minute, data);
    }

    @Override
    public List<RTimer> getDate() {
        Date date = new Date();
        List<RTimer> list = new CopyOnWriteArrayList<>();
        for (String key1 : map.keySet()) {
            Map<String, RTimer> timerMap = map.get(key1);
            long l = date.getTime() - DateUtils.getDate(key1,"yyyy-MM-dd HH:mm").getTime();
            if ( l> 61000) {
                for (String key2 : timerMap.keySet()) {
                    list.add(timerMap.get(key2));
                }
                map.remove(key1);
            } else {
                for (String key2 : timerMap.keySet()) {
                    if (date.getTime() - DateUtils.getDate(key2).getTime() > 3000) {
                        list.add(timerMap.get(key2));
                        timerMap.remove(key2);
                    }
                }
            }
        }
        return list;
    }
}
