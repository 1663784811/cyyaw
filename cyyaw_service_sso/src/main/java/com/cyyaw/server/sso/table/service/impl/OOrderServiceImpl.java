package com.cyyaw.server.sso.table.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.common.jpa.BaseService;
import com.cyyaw.server.sso.table.service.OOrderService;
import com.cyyaw.server.sso.table.table.dao.OOrderDao;
import com.cyyaw.server.sso.table.table.entity.OOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class OOrderServiceImpl extends BaseService<OOrder, Integer> implements OOrderService {

    @Autowired
    private OOrderDao oOrderDao;

    @Override
    public BaseDao getBaseDao() {
        return oOrderDao;
    }



    @Override
    public JSONArray findByUserid(String uid, Integer page, Integer size) {
        JSONArray arr = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("aaa", "cccc");
        json.put("aaa1", "cccc");
        json.put("aaa2", "cccc");
        json.put("aaa3", "cccc");
        json.put("aaa4", "cccc");
        arr.add(json);
        return arr;
    }
}

