package com.cyyaw.reptiles.table.service.impl;


import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.jpa.BaseService;
import com.cyyaw.reptiles.table.dao.RUrlDao;
import com.cyyaw.reptiles.table.entity.RUrl;
import com.cyyaw.reptiles.table.service.RUrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class RUrlServiceImpl extends BaseService<RUrl, Integer> implements RUrlService {

    @Autowired
    private RUrlDao rUrlDao;

    @Override
    public BaseDao getBaseDao() {
        return rUrlDao;
    }

}

