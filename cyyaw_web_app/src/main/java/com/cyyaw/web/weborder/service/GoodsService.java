package com.cyyaw.web.weborder.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cyyaw-service-goods")
public interface GoodsService {


    @GetMapping(value = "/goods/search" ,produces = "application/json; charset=UTF-8")
    BaseResult search(
            @PathVariable(value = "page") Integer page,
            @PathVariable(value = "size") Integer size,
            @PathVariable(value = "search", required = false) String search
    );
}
