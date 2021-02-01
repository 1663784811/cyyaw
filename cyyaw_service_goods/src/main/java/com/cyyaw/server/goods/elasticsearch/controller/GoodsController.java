package com.cyyaw.server.goods.elasticsearch.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.entity.SelectEntity;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.ResponseUtils;
import com.cyyaw.server.common.jpa.JpaUtils;
import com.cyyaw.server.common.jpa.PageUtil;
import com.cyyaw.server.goods.elasticsearch.entity.GoodsList;
import com.cyyaw.server.goods.elasticsearch.service.GoodsService;
import com.cyyaw.server.goods.table.entity.GGoods;
import com.cyyaw.server.goods.table.entity.GSku;
import com.cyyaw.server.goods.table.service.GGoodsService;
import com.cyyaw.server.goods.table.service.GSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RequestMapping("/goods/goods")
@RestController
public class GoodsController {


    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GSkuService gSkuService;


    @Autowired
    private GGoodsService gGoodsService;


    /**
     * 分页条件查询
     */
    @RequestMapping(value = "/findPage")
    public BaseResult findPageGGoods(String jsonStr, SelectEntity selectEntity) {
        PageRequest pageRequest = JpaUtils.getPageRequest(selectEntity);
        Page<GGoods> data = gGoodsService.findPage(jsonStr, pageRequest);
        List<GGoods> content = data.getContent();
        long total = data.getTotalElements();
        int page = pageRequest.getPageNumber()+1;
        int size = pageRequest.getPageSize();
        return BaseResult.ok(content, new BaseResult.Result(page,size, total));
    }



    //=======================================================================
    /**
     * 获取我的订单列表
     */
    @GetMapping("/search")
    public BaseResult search(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "search", required = false) String search
    ) {
        return goodsService.search(search, page, size);
    }

    /**
     * 导入 ElasticSearch
     *
     * @return
     */
    @GetMapping("/importElasticSearch")
    public List<GGoods> importElasticSearch() {
        return goodsService.importElasticSearch();
    }

    @PostMapping("/saveGoods")
    public BaseResult saveGoods(@RequestBody JSONObject json) {
        JSONObject obj = goodsService.saveGoods(json);
        return BaseResult.ok(obj);
    }

    @PostMapping("/findSku")
    public List<GSku> findSku(@RequestBody List<String> list) {
        return gSkuService.findBySkuList(list);
    }






}
