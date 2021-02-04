package com.cyyaw.server.tx.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.tx.table.dao.TAdminDao;
import com.cyyaw.server.tx.table.entity.TAdmin;
import com.cyyaw.server.tx.table.service.TAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TAdminServiceImpl extends BaseService<TAdmin, Integer> implements TAdminService {

    @Autowired
    private TAdminDao tAdminDao;

    @Override
    public BaseDao getBaseDao() {
        return tAdminDao;
    }

    @Override
    public TAdmin findByAccount(String account) {
        return tAdminDao.findByAccount(account);
    }
}

