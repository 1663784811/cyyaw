package com.cyyaw.reptiles.table.dao;


import cn.cyyaw.jpa.BaseDao;
import com.cyyaw.reptiles.table.entity.RImg;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RImgDao extends BaseDao<RImg, Integer> {


    @Query("select count(m) from RImg m where m.url = ?1")
    long urlCount(String url);

    @Query("select m from RImg m where  m.alt like %?1% or m.tid = ?1")
    List<RImg> getImgList(String search, Pageable page);

    @Query("select count(m) from RImg m where  m.alt like %?1% or m.tid = ?1")
    long getImgListCount(String search);
}
