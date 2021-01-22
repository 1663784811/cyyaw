package com.cyyaw.web.admin.controller;



import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.web.admin.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/admin/goods/depository")
@RestController
public class DepositoryController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/findDepositoryList")
    public BaseResult findDepositoryList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size
    ) {
        return goodsService.findDepositoryList(page, size);
    }

    @RequestMapping(value = "/saveDepository")
    public BaseResult saveDepository(@RequestBody JSONObject json) {
        return goodsService.saveDepository(json);
    }


}
