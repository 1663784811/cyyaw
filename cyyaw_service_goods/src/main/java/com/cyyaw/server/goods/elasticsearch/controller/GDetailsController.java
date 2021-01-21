package com.cyyaw.server.goods.elasticsearch.controller;

import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.goods.table.entity.GDetails;
import com.cyyaw.server.goods.table.service.GDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/goods/details")
@RestController
public class GDetailsController {


    @Autowired
    private GDetailsService gDetailsService;


    @RequestMapping("/findByGoodsid")
    public BaseResult findByGoodsid(String goodsid) {
        List<GDetails> gDetails = gDetailsService.findByGoodsid(goodsid);
        return BaseResult.ok(gDetails);
    }


}
