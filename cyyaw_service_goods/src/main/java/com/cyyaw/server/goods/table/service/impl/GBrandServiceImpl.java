package com.cyyaw.server.goods.table.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.common.jpa.CommonDao;
import com.cyyaw.server.goods.table.dao.GBrandDao;
import com.cyyaw.server.goods.table.entity.GBrand;
import com.cyyaw.server.goods.table.entity.GType;
import com.cyyaw.server.goods.table.service.GBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class GBrandServiceImpl extends BaseService<GBrand, Integer> implements GBrandService {

    @Autowired
    private GBrandDao gBrandDao;

    @Autowired
    private CommonDao commonDao;

    @Override
    public BaseDao getBaseDao() {
        return gBrandDao;
    }

    @Override
    public GBrand saveBrand(GBrand gBrand) {
        JSONArray list = new JSONArray();
        list.add(gBrand);
        JSONArray objs = commonDao.update("g_brand", list);
        return objs.getObject(0, GBrand.class);
    }
}

