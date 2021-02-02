package com.cyyaw.server.goods.table.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.common.jpa.CommonDao;
import com.cyyaw.server.goods.table.dao.GTypeDao;
import com.cyyaw.server.goods.table.entity.GType;
import com.cyyaw.server.goods.table.service.GTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
@Slf4j
public class GTypeServiceImpl extends BaseService<GType, Integer> implements GTypeService {

    @Autowired
    private GTypeDao gTypeDao;

    @Autowired
    private CommonDao commonDao;

    @Override
    public BaseDao getBaseDao() {
        return gTypeDao;
    }

    @Override
    public GType saveType(GType gType) {
        JSONArray list = new JSONArray();
        list.add(gType);
        JSONArray objs = commonDao.update("cyyaw_goods","g_type", list);
        return objs.getObject(0, GType.class);
    }
}

