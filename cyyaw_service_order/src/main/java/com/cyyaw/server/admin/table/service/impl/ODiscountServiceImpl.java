package com.cyyaw.server.admin.table.service.impl;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.common.jpa.BaseService;
import com.cyyaw.server.admin.table.service.ODiscountService;
import com.cyyaw.server.admin.table.table.dao.ODiscountDao;
import com.cyyaw.server.admin.table.table.entity.ODiscount;
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

