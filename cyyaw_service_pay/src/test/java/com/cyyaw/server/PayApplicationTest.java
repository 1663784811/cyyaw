package com.cyyaw.server;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.server.pay.service.ComputedService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PayApplicationTest {


    @Autowired
    private ComputedService computedService;


    @Test
    public void test001(){
        JSONObject js = new JSONObject();

        JSONArray arr = new JSONArray();
        JSONObject jso = new JSONObject();
        jso.put("tid","cdea3694738f4b4c953969114bf835a6");

        arr.add(jso);

        js.put("skus", arr);

        computedService.computeGoods(js);
    }


}
