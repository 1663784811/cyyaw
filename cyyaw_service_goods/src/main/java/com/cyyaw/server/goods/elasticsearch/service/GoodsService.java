package com.cyyaw.server.goods.elasticsearch.service;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.goods.elasticsearch.entity.GoodsList;
import com.cyyaw.server.goods.table.entity.GGoods;
import netscape.javascript.JSObject;

import java.util.List;
import java.util.Map;

public interface GoodsService {


    BaseResult search(String search, Integer page, Integer size);

    GoodsList save(GoodsList goodsList);

    List<GGoods> importElasticSearch();

    JSONObject goodsInfo(String tid);

    JSONObject saveGoods(JSONObject json);

}
