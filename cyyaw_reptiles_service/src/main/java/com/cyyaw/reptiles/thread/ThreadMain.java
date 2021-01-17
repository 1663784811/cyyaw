package com.cyyaw.reptiles.thread;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.reptiles.table.service.RWebContentService;
import com.cyyaw.reptiles.thread.reptile.ReptilesData;
import com.cyyaw.reptiles.thread.reptile.ReptilesDataThread;
import com.cyyaw.reptiles.thread.timer.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ThreadMain {

    //爬取线程池
    public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    //处理数据线种池
    public static ExecutorService handleData = Executors.newCachedThreadPool();


    private ReptilesData at = new ReptilesDataThread();



    @Autowired
    private RWebContentService rWebContentService;

    // 工作线程正爬取地址
    private volatile ConcurrentMap<String, JSONObject> concurrentMap = new ConcurrentHashMap();

    // 爬取的数据
    private volatile ConcurrentMap<String, String> reptilesData = new ConcurrentHashMap();

    @Autowired
    private Timer timer;


    public void run(String url) {
        if (rWebContentService.urlCount(url) > 0) {
            return;
        }
        while (concurrentMap.size() > 100 || reptilesData.size() > 10) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        JSONObject js = new JSONObject();
        js.put("url", url);
        concurrentMap.put(url, js);
        cachedThreadPool.execute(() -> {
            timer.count();
            String reptiles = at.reptiles(url, null);
//            reptilesData.put(url, reptiles);
            System.out.println("=======================================================");
            concurrentMap.remove(url);
        });
    }


    private void headleData(){


        handleData.execute(() -> {

        });
    }


    public ConcurrentMap<String, JSONObject> getConcurrentMap() {
        return concurrentMap;
    }
}
