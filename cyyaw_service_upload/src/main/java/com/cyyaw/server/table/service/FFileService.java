package com.cyyaw.server.table.service;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.common.jpa.BaseTableService;
import com.cyyaw.server.table.entity.FFile;

import java.util.List;

public interface FFileService extends BaseTableService<FFile, Integer> {


    BaseResult findFileList(Integer page, Integer size, String name);
}
