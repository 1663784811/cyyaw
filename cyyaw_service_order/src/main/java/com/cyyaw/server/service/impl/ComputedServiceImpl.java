package com.cyyaw.server.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.service.ComputedService;
import com.cyyaw.server.service.GoodsService;
import com.cyyaw.server.service.impl.design.computedgoods.ComputedRest;
import com.cyyaw.server.service.impl.design.computedgoods.GoodsComput;
import com.cyyaw.server.service.impl.design.computedgoods.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class ComputedServiceImpl implements ComputedService {


    @Autowired
    private GoodsService goodsService;


    @Override
    public ComputedRest computeGoods(ComputedRest computedRest) {
        List<Sku> skus = computedRest.getSkuList();
        List<String> skusid = new ArrayList<>();
        for (int i = 0; i < skus.size(); i++) {
            Sku sku = skus.get(i);
            String tid = sku.getTid();
            skusid.add(tid);
        }
        List<JSONObject> sku = goodsService.findSku(skusid);
        List<Sku> resSku = new ArrayList<>();
        for (int i = 0; i <sku.size(); i++) {
            JSONObject jsonObject = sku.get(i);
            String tid = jsonObject.getString("tid");
            for (int j = 0; j < skus.size(); j++) {
                Sku sk = skus.get(i);
                String tid1 = sk.getTid();
                if(tid.equals(tid1)){



                    resSku.add(sk);
                    break;
                }
            }
        }


        ComputedRest  computed = new ComputedRest();
        computed.setSkuList(resSku);
        computed.setTotal(100);
        computed.setComputedPrice(new BigDecimal("200"));
        computed.setActivePrice(new BigDecimal("123.12"));
        computed.setTotalPrice(new BigDecimal("23.2"));
        return computed;
    }


}
