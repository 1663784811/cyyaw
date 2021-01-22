package com.cyyaw.server.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.ODiscountDao;
import com.cyyaw.server.table.entity.ODiscount;
import com.cyyaw.server.table.service.ODiscountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class ODiscountServiceImpl extends BaseService<ODiscount, Integer> implements ODiscountService {

    @Autowired
    private ODiscountDao oDiscountDao;

    @Override
    public BaseDao getBaseDao() {
        return oDiscountDao;
    }

}

