package com.cyyaw.server.table.service.impl;

import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.EPhotoDao;
import com.cyyaw.server.table.entity.EPhoto;
import com.cyyaw.server.table.service.EPhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EPhotoServiceImpl extends BaseService<EPhoto, Integer> implements EPhotoService {

    @Autowired
    private EPhotoDao ePhotoDao;

    @Override
    public BaseDao getBaseDao() {
        return ePhotoDao;
    }

}

