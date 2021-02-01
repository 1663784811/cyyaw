package com.cyyaw.server.goods.elasticsearch.dao;


import com.cyyaw.server.goods.elasticsearch.entity.GoodsList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface GoodsSearchDao extends PagingAndSortingRepository<GoodsList, String> {



}
