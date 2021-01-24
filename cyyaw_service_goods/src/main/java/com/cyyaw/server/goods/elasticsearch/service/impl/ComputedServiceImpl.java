package com.cyyaw.server.goods.elasticsearch.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.server.goods.elasticsearch.service.ComputedService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ComputedServiceImpl implements ComputedService {


    @Override
    public JSONObject computedGoods(JSONObject json) {

        //BigDecimal.ZERO;
        // 商品总价 = 商品单价 * 数量
        json.getJSONArray("goods");// 商品

//        for(){
//
//        }
//
//
//
        // 活动优惠
            // 满赠 、每满赠
            // 满减 、每满减
            // 团购
            //
            // 秒杀（不做在这）

        //

        // 服务

        // 运费
        //


        // 计算商品总价


        // 最后售价 = 计算商品总价 - 活动优惠


        return null;
    }
}
