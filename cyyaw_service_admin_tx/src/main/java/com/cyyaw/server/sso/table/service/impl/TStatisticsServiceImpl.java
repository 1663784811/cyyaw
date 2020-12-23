package com.cyyaw.server.sso.table.service.impl;


import com.cyyaw.common.jpa.BaseDao;
import com.cyyaw.common.jpa.BaseService;
import com.cyyaw.server.sso.table.service.TStatisticsService;
import com.cyyaw.server.sso.table.table.dao.TStatisticsDao;
import com.cyyaw.server.sso.table.table.entity.TStatistics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TStatisticsServiceImpl extends BaseService<TStatistics, Integer> implements TStatisticsService {

    @Autowired
    private TStatisticsDao tStatisticsDao;

    @Override
    public BaseDao getBaseDao() {
        return tStatisticsDao;
    }

}

