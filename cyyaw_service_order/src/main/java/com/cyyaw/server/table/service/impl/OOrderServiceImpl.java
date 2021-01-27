package com.cyyaw.server.table.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.OOrderDao;
import com.cyyaw.server.table.entity.OOrder;
import com.cyyaw.server.table.service.OOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public BaseResult findOrderList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<OOrder> all = oOrderDao.findAll(pageable);
        List<OOrder> content = all.getContent();
        long total = all.getTotalElements();
        return BaseResult.ok(content, new BaseResult.Result(page,size, total));
    }

    @Override
    public BaseResult createOrder(JSONObject json) {












        return null;
    }
}

