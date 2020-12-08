package com.cyyaw.server.admin.table.service.impl;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.common.jpa.BaseService;
import com.cyyaw.server.admin.table.service.PFieldService;
import com.cyyaw.server.admin.table.table.dao.PFieldDao;
import com.cyyaw.server.admin.table.table.entity.PField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class PFieldServiceImpl extends BaseService<PField, Integer> implements PFieldService {

    @Autowired
    private PFieldDao pFieldDao;

    @Override
    public BaseDao getBaseDao() {
        return pFieldDao;
    }

}

