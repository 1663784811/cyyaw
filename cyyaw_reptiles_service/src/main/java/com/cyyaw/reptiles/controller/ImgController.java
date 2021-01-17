package com.cyyaw.reptiles.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.reptiles.table.service.RImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/img")
@RestController
public class ImgController {


    @Autowired
    private RImgService rImgService;


    @RequestMapping("/getImgList")
    public BaseResult getImgList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "search", defaultValue = "") String search
    ){

       return rImgService.getImgList(page,size,search);
    }











}
