package com.cyyaw.server.service.impl.design.computedgoods;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.service.GoodsService;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算商品价格（模板设计模式）
 */
@Data
public abstract class ComputedTemplate {



   private ComputedRest computedRest;



    /**
     * 计算商品价格
     */
    public ComputedRest computed() {


//        // 优惠券
//        if (null != couponList && couponList.size() > 0) {
//            // 查优惠券
//            // 判断是不互斥，若互斥则抛异常
//
//        }
//
//        List<String> tidArr = new ArrayList<>();
//        for (int i = 0; i < goodsList.size(); i++) {
//            Sku sku = goodsList.get(i);
//            tidArr.add(sku.getTid());
//        }
//
//        // 查询商品
//        List<JSONObject> sku = goodsService.findSku(tidArr);
//
//
//        ComputedRest computedRest = new ComputedRest();
//
//        computedRest.setTotal(100);

        computedFn();

        return computedRest;
    }




    public void computedFn(){

    }






}
