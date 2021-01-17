package com.cyyaw.reptiles.table.service.impl;


import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.jpa.BaseService;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.reptiles.table.dao.RTimerDao;
import com.cyyaw.reptiles.table.entity.RTimer;
import com.cyyaw.reptiles.table.service.RTimerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class RTimerServiceImpl extends BaseService<RTimer, Integer> implements RTimerService {

    @Autowired
    private RTimerDao rTimerDao;

    @Override
    public BaseDao getBaseDao() {
        return rTimerDao;
    }

    @Override
    public List<RTimer> saveList(List<RTimer> data) {
        for (int i = 0; i < data.size(); i++) {
            RTimer rTimer = data.get(i);
            String tid = rTimer.getTid();
            if (null == tid) {
                rTimer.setTid(StringUtilWHY.getUUID());
            }
        }
        return rTimerDao.saveAll(data);
    }
}

