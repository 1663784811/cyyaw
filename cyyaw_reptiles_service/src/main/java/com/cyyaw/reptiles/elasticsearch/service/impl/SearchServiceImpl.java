package com.cyyaw.reptiles.elasticsearch.service.impl;

import com.cyyaw.common.res.BaseResult;
import com.cyyaw.reptiles.elasticsearch.dao.ReptilesSearchDao;
import com.cyyaw.reptiles.elasticsearch.entity.ReptilesContent;
import com.cyyaw.reptiles.elasticsearch.service.SearchService;
import com.cyyaw.reptiles.table.dao.RWebContentDao;
import com.cyyaw.reptiles.table.entity.RWebContent;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class SearchServiceImpl implements SearchService {


    @Autowired
    private ReptilesSearchDao reptilesSearchDao;

    @Autowired
    private RWebContentDao rWebContentDao;


    @Override
    public BaseResult searchContent(Integer page, Integer size, String search, String type) {
        PageRequest of = PageRequest.of(page-1, size);
//        List<ReptilesContent> reptilesContents = reptilesSearchDao.searchContent(search, of);
        Page<ReptilesContent> rep = reptilesSearchDao.findAll(of);
        List<ReptilesContent> content = rep.getContent();
        BaseResult.Result result = new BaseResult.Result();
        result.setTotal(rep.getTotalElements());
        result.setPage(page);
        result.setSize(size);
        return BaseResult.ok(content,result);
    }



    @Override
    public BaseResult searchImport() {
        Integer page = 0;
        Integer size = 100;
        long count = rWebContentDao.count();
        while (count>page*size){
            PageRequest of = PageRequest.of(page, size);
            Page<RWebContent> all = rWebContentDao.findAll(of);
            List<RWebContent> content = all.getContent();
            ArrayList<ReptilesContent> reptilesContentList = new ArrayList<>();
            for (int i = 0; i < content.size(); i++) {
                RWebContent rWebContent = content.get(i);
                ReptilesContent rep = new ReptilesContent();
                rep.setTid(rWebContent.getTid());
                rep.setNote(rWebContent.getNote());
                rep.setCreatetime(rWebContent.getCreatetime());
                rep.setReptilesurlid(rWebContent.getReptilesurlid());
                rep.setUrl(rWebContent.getUrl());
                rep.setBaseuri(rWebContent.getBaseuri());
                rep.setRequesttype(rWebContent.getRequesttype());
                rep.setContenttxt(rWebContent.getContenttxt());
                rep.setTitle(rWebContent.getTitle());
                reptilesContentList.add(rep);
            }
            reptilesSearchDao.saveAll(reptilesContentList);
            page++;
        }
        return BaseResult.ok();
    }
}
