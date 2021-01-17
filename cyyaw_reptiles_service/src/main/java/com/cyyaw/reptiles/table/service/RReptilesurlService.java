package com.cyyaw.reptiles.table.service;


import cn.cyyaw.jpa.BaseTableService;
import com.cyyaw.reptiles.table.entity.RReptilesurl;

public interface RReptilesurlService extends BaseTableService<RReptilesurl, Integer> {


    RReptilesurl saveReptilesurl(RReptilesurl rReptilesurl);
}
