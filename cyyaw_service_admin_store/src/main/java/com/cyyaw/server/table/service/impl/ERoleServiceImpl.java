package com.cyyaw.server.table.service.impl;

import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.ERoleDao;
import com.cyyaw.server.table.entity.ERole;
import com.cyyaw.server.table.service.ERoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class ERoleServiceImpl extends BaseService<ERole, Integer> implements ERoleService {

    @Autowired
    private ERoleDao eRoleDao;

    @Override
    public BaseDao getBaseDao() {
        return eRoleDao;
    }

}
