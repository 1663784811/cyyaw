package com.cyyaw.server.table.service.impl;

import com.cyyaw.server.common.jpa.BaseDao;
import com.cyyaw.server.common.jpa.BaseService;
import com.cyyaw.server.table.dao.EStatisticsDao;
import com.cyyaw.server.table.entity.EStatistics;
import com.cyyaw.server.table.service.EStatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class EStatisticsServiceImpl extends BaseService<EStatistics, Integer> implements EStatisticsService {

    @Autowired
    private EStatisticsDao eStatisticsDao;

    @Override
    public BaseDao getBaseDao() {
        return eStatisticsDao;
    }

}

