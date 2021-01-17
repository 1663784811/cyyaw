package com.cyyaw.reptiles.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.reptiles.elasticsearch.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {


    @Autowired
    private SearchService searchService;


    @RequestMapping("/searchContent")
    public BaseResult searchContent(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "search", defaultValue = "") String search,
            @RequestParam(value = "type", defaultValue = "") String type
    ){
       return searchService.searchContent(page,size,search,type);
    }


    @RequestMapping("/searchImport")
    public BaseResult searchImport(    ){
        return searchService.searchImport();
    }

}
