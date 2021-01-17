package com.cyyaw.reptiles.table.service;

import cn.cyyaw.jpa.BaseTableService;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.reptiles.table.entity.RImg;

import java.util.List;

public interface RImgService extends BaseTableService<RImg, Integer> {


    List<RImg> saveList(List<RImg> list);

    BaseResult getImgList(Integer page, Integer size, String search);




}
