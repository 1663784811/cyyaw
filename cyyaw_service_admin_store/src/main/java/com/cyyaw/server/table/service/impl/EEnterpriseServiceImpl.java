package com.cyyaw.server.table.service.impl;

import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.EEnterpriseDao;
import com.cyyaw.server.table.entity.EEnterprise;
import com.cyyaw.server.table.service.EEnterpriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EEnterpriseServiceImpl extends BaseService<EEnterprise, Integer> implements EEnterpriseService {

    @Autowired
    private EEnterpriseDao eEnterpriseDao;

    @Override
    public BaseDao getBaseDao() {
        return eEnterpriseDao;
    }

    @Override
    public EEnterprise saveEnterprise(EEnterprise eEnterprise) {
        String tid = eEnterprise.getTid();
        if(StringUtilWHY.isEmpty(tid)){
            eEnterprise.setTid(StringUtilWHY.getUUID());
        }
        return eEnterpriseDao.save(eEnterprise);
    }
}

