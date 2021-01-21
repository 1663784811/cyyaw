package com.cyyaw.server.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.EAdminDao;
import com.cyyaw.server.table.entity.EAdmin;
import com.cyyaw.server.table.service.EAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EAdminServiceImpl extends BaseService<EAdmin, Integer> implements EAdminService {

    @Autowired
    private EAdminDao eAdminDao;

    @Override
    public BaseDao getBaseDao() {
        return eAdminDao;
    }

}

