package com.cyyaw.web.admin.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/config/common")
@RestController
public class ConfigCommonController {

    @Autowired
    private PageService pageService;

    /**
     * 通用查询
     *
     * @return
     */
    @RequestMapping("/query")
    public BaseResult query(@RequestBody Map<String,Object> map) {
        return pageService.query(map);
    }

    /**
     * 通用修改或添加
     */
    @RequestMapping("/update")
    public BaseResult update(@RequestBody Map<String,Object> map) {
        return pageService.update(map);
    }

    /**
     * 通用删除
     */
    @RequestMapping("/delete")
    public BaseResult delete(@RequestBody Map<String,Object> map) {
        return pageService.delete(map);
    }


}
