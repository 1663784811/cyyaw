package com.cyyaw.reptiles.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.reptiles.table.service.RWebContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/webcontent")
@RestController
public class RWebContentController {

    @Autowired
    private RWebContentService rWebContentService;


    @RequestMapping("/findByTid")
    public BaseResult findByTid(@RequestParam("tid") String tid){
        return rWebContentService.findByTid(tid);
    }

}
