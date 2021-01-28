package com.cyyaw.server.table.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.common.jpa.BaseTableService;
import com.cyyaw.server.service.impl.design.computedgoods.ComputedRest;
import com.cyyaw.server.table.entity.OOrder;

public interface OOrderService extends BaseTableService<OOrder, Integer> {

    /**
     * 获取我的订单
     * @param uid  用户ID
     * @param page 分页
     * @param size 大小
     * @return
     */
    JSONArray findByUserid(String uid, Integer page, Integer size);

    BaseResult findOrderList(Integer page, Integer size);

    ComputedRest createOrder(JSONObject json);

}
