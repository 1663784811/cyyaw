package com.cyyaw.server.sso.table.service;


import com.alibaba.fastjson.JSONArray;
import com.cyyaw.server.common.jpa.BaseTableService;
import com.cyyaw.server.sso.table.table.entity.OOrder;

public interface OOrderService extends BaseTableService<OOrder, Integer> {

    /**
     * 获取我的订单
     * @param uid  用户ID
     * @param page 分页
     * @param size 大小
     * @return
     */
    JSONArray findByUserid(String uid, Integer page, Integer size);
}
