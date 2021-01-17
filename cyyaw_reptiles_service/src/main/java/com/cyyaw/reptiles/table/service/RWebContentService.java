package com.cyyaw.reptiles.table.service;

import cn.cyyaw.jpa.BaseTableService;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.reptiles.table.entity.RWebContent;

import java.util.List;

public interface RWebContentService extends BaseTableService<RWebContent, Integer> {


    long urlCount(String url);


    List<RWebContent> saveList(List<RWebContent> list);

    BaseResult findByTid(String tid);


}
