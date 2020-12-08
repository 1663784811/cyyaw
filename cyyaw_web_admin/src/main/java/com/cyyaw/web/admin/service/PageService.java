package com.cyyaw.web.admin.service;

import com.cyyaw.common.res.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("cyyaw-service-page")
public interface PageService {

    @RequestMapping(value = "/config/page/pageConfig" ,produces = "application/json; charset=UTF-8")
    BaseResult pageConfig(@RequestParam("pageid") String pageid);


    @RequestMapping(value = "/config/common/query" ,produces = "application/json; charset=UTF-8")
    BaseResult query(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/config/common/update" ,produces = "application/json; charset=UTF-8")
    BaseResult update(Map<String, Object> map);

    @RequestMapping(value = "/config/common/delete" ,produces = "application/json; charset=UTF-8")
    BaseResult delete(Map<String, Object> map);
}
