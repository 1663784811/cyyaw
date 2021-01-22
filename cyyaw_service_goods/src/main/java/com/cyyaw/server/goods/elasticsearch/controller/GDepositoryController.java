package com.cyyaw.server.goods.elasticsearch.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.goods.table.service.GDepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/goods/depository")
@RestController
public class GDepositoryController {

    @Autowired
    private GDepositoryService gDepositoryService;


    @GetMapping(value = "/findDepositoryList")
    public BaseResult findDepositoryList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size
    ) {
        return gDepositoryService.findDepositoryList(page, size);
    }


}
