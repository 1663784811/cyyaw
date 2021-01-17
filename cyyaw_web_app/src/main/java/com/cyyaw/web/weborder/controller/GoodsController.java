package com.cyyaw.web.weborder.controller;

import com.cyyaw.web.weborder.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pc/goods")
@RestController
public class GoodsController {


    @Autowired
    private GoodsService goodsService;


    @GetMapping("/search")
    public void search(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "search", required = false) String search
    ) {
        goodsService.search(page,size,search);
    }


}
