package com.cyyaw.server.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.service.ComputedService;
import com.cyyaw.server.service.GoodsService;
import com.cyyaw.server.service.impl.design.computedgoods.ComputedRest;
import com.cyyaw.server.service.impl.design.computedgoods.GoodsComput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ComputedServiceImpl implements ComputedService {


    @Autowired
    private GoodsService goodsService;


    @Override
    public BaseResult computeGoods(JSONObject json) {

//        GoodsComput goodsComput = new GoodsComput(goodsService);
////        goodsComput.setGoodsList();
//        ComputedRest computed = goodsComput.computed();

        JSONArray jsonArray = json.getJSONArray("goodslist");

        ComputedRest  computed = new ComputedRest();
        computed.setTotal(100);



        return BaseResult.ok(computed);
    }


}
