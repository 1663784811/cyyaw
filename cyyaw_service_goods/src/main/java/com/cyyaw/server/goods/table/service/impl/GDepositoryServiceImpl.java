package com.cyyaw.server.goods.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.goods.table.dao.GDepositoryDao;
import com.cyyaw.server.goods.table.entity.GDepository;
import com.cyyaw.server.goods.table.service.GDepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class GDepositoryServiceImpl extends BaseService<GDepository, Integer> implements GDepositoryService {

    @Autowired
    private GDepositoryDao gDepositoryDao;

    @Override
    public BaseDao getBaseDao() {
        return gDepositoryDao;
    }

}

