package com.cyyaw.server.pay.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.server.pay.service.ComputedService;
import com.cyyaw.server.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ComputedServiceImpl implements ComputedService {


    @Autowired
    private GoodsService goodsService;


    @Override
    public JSONObject computeGoods(JSONObject json) {

        JSONArray skus = json.getJSONArray("skus");
        List<String> skustring = new ArrayList<>();
        for(int i=0;i<skus.size();i++){
            JSONObject js = skus.getJSONObject(i);
            skustring.add(js.getString("tid"));
        }
        List<JSONObject> sku = goodsService.findSku(skustring);

                   System.out.println(sku);

        return null;
    }




}
