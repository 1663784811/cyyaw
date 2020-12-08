package com.cyyaw.web.admin.controller;

import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RequestMapping("/config/page")
@RestController
public class ConfigPageController {


    @Autowired
    private PageService pageService;


    /**
     * 获取页面设置
     */
    @RequestMapping("/pageConfig")
    public BaseResult pageConfig(@RequestBody Map<String, Object> map) {
        String pageid = map.get("tid").toString();
        return pageService.pageConfig(pageid);
    }

}
