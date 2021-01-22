package com.cyyaw.server.table.service;




import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "cyyaw-service-goods")
public interface GoodsService {

    @RequestMapping(value = "/goods/findSku" ,produces = "application/json; charset=UTF-8")
    List<JSONObject> findSku(@RequestBody List<String> list);

}
