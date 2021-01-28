package com.cyyaw.server.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.server.service.ComputedService;
import com.cyyaw.server.service.GoodsService;
import com.cyyaw.server.service.impl.design.computedgoods.ComputedRest;
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
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal computedPrice = BigDecimal.ZERO;
        BigDecimal activePrice = BigDecimal.ZERO;
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (int i = 0; i <sku.size(); i++) {
            JSONObject js = sku.get(i);
            String tid = js.getString("tid");
            for (int j = 0; j < skus.size(); j++) {
                Sku sk = skus.get(i);
                String tid1 = sk.getTid();
                if(tid.equals(tid1)){
                    BigDecimal price = js.getBigDecimal("price"); // 单价*数量
                    BigDecimal number = sk.getNumber(); // 数量
                    BigDecimal tp = price.multiply(number); // 总价
                    sk.setGoodsid(js.getString("goodsid"));
                    sk.setNote(js.getString("note"));
                    sk.setPhoto(js.getString("photo"));
                    sk.setAttribute(js.getString("attribute"));
                    sk.setTotalPrice(tp);
                    sk.setPrice(price);
                    resSku.add(sk);
                    //========
                    total = total.add(number);
                    totalPrice = totalPrice.add(tp);
                    computedPrice = computedPrice.add(tp);
                    break;
                }
            }
        }
        ComputedRest  computed = new ComputedRest();
        computed.setSkuList(resSku);
        computed.setTotal(total);
        computed.setComputedPrice(computedPrice);
        computed.setActivePrice(activePrice);
        computed.setTotalPrice(totalPrice);
        return computed;
    }


}
