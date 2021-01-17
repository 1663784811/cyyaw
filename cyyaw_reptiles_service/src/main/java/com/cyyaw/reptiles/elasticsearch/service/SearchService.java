package com.cyyaw.reptiles.elasticsearch.service;

import com.cyyaw.common.res.BaseResult;

public interface SearchService {

    BaseResult searchContent(Integer page, Integer size, String search, String type);

    BaseResult searchImport();
}
