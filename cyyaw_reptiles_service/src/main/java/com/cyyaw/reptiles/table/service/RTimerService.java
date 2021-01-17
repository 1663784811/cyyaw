package com.cyyaw.reptiles.table.service;


import cn.cyyaw.jpa.BaseTableService;
import com.cyyaw.reptiles.table.entity.RTimer;

import java.util.List;

public interface RTimerService extends BaseTableService<RTimer, Integer> {


    List<RTimer> saveList(List<RTimer> data);
}
