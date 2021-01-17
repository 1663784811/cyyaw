package com.cyyaw.server.goods.elasticsearch.dao;


import com.cyyaw.server.goods.elasticsearch.entity.GoodsList;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GoodsSearchDao extends PagingAndSortingRepository<GoodsList, String> {



}
