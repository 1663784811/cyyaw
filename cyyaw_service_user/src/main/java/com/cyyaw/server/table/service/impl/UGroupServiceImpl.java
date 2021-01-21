package com.cyyaw.server.table.service.impl;


import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.UGroupDao;
import com.cyyaw.server.table.entity.UGroup;
import com.cyyaw.server.table.service.UGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UGroupServiceImpl extends BaseService<UGroup, Integer> implements UGroupService {

    @Autowired
    private UGroupDao uGroupDao;

    @Override
    public BaseDao getBaseDao() {
        return uGroupDao;
    }

}

