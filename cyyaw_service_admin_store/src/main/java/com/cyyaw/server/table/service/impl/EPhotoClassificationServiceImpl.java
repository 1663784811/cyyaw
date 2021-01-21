package com.cyyaw.server.table.service.impl;

import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.EPhotoClassificationDao;
import com.cyyaw.server.table.entity.EPhotoClassification;
import com.cyyaw.server.table.service.EPhotoClassificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EPhotoClassificationServiceImpl extends BaseService<EPhotoClassification, Integer> implements EPhotoClassificationService {

    @Autowired
    private EPhotoClassificationDao ePhotoClassificationDao;

    @Override
    public BaseDao getBaseDao() {
        return ePhotoClassificationDao;
    }

}

