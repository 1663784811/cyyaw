package com.cyyaw.server.table.service.impl;


import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.EAdminDao;
import com.cyyaw.server.table.dao.EEnterpriseDao;
import com.cyyaw.server.table.dao.EStoreDao;
import com.cyyaw.server.table.entity.EAdmin;
import com.cyyaw.server.table.entity.EEnterprise;
import com.cyyaw.server.table.entity.EStore;
import com.cyyaw.server.table.service.EAdminService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EAdminServiceImpl extends BaseService<EAdmin, Integer> implements EAdminService {

    @Autowired
    private EAdminDao eAdminDao;

    @Autowired
    private EEnterpriseDao enterpriseDao;

    @Autowired
    private EStoreDao eStoreDao;

    @Override
    public BaseDao getBaseDao() {
        return eAdminDao;
    }

    @Override
    public EAdmin findByAccount(String account) {
        return eAdminDao.findByAccount(account);
    }

    @Override
    public EAdmin findByAccountAndEnterpriseNo(String account, String enterprise, String code) {
        if (StringUtilWHY.isEmpty(enterprise)) {
            EStore store = eStoreDao.findByCode(code);
            String tid = store.getTid();
            return eAdminDao.findByAccountAndStoreCode(account,tid);
        } else {
            EEnterprise e = enterpriseDao.findByCode(enterprise);
            String tid = e.getTid();
            return eAdminDao.findByAccountAndEnterpriseid(account, tid);
        }

    }
}

