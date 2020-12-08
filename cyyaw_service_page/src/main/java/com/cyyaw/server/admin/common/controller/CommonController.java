package com.cyyaw.server.admin.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.admin.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/config/common")
@RestController
public class CommonController {



    @Autowired
    private CommonService commonService;

    /**
     * 通用查询
     *
     * @return
     */
    @RequestMapping("/query")
    public BaseResult query(@RequestBody Map<String,Object> map) {
        JSONObject json = new JSONObject();
        for (String key: map.keySet()) {
            json.put(key,map.get(key));
        }
        Map<String, Object> query = commonService.query(json);
        return BaseResult.ok(query);
    }


    /**
     * 通用修改或添加
     */
    @RequestMapping("/update")
    public Map<String, Object> update(@RequestBody Map<String,Object> map) {
        JSONObject json = new JSONObject();
        for (String key: map.keySet()) {
            json.put(key,map.get(key));
        }
        return commonService.update(json);
    }

    /**
     * 通用删除
     */
    @RequestMapping("/delete")
    public Map<String, Object> delete(@RequestBody Map<String,Object> map) {
        JSONObject json = new JSONObject();
        for (String key: map.keySet()) {
            json.put(key,map.get(key));
        }
        return commonService.delete(json);
    }

}
