package com.cyyaw.reptiles.table.dao;

import cn.cyyaw.jpa.BaseDao;
import com.cyyaw.reptiles.table.entity.RWebContent;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.data.jpa.repository.Query;

public interface RWebContentDao extends BaseDao<RWebContent, Integer> {


    @Query("select count(m) from RWebContent m where m.url=?1")
    long urlCount(String webAdd);


    RWebContent findByTid(String tid);

}
