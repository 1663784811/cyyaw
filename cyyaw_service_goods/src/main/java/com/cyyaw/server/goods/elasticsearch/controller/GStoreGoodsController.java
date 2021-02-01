package com.cyyaw.server.goods.elasticsearch.controller;


import com.cyyaw.common.entity.SelectEntity;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.common.jpa.BaseConstants;
import com.cyyaw.server.common.jpa.JpaUtils;
import com.cyyaw.server.goods.table.entity.GStoreGoods;
import com.cyyaw.server.goods.table.service.GStoreGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/goods/storegoods")
@RestController
public class GStoreGoodsController {

    @Autowired
    private GStoreGoodsService gStoreGoodsService;

    /**
     * 分页条件查询
     */
    @GetMapping(value = "/findPage")
    public BaseResult findPageGStoreGoods(String jsonStr, SelectEntity selectEntity) {
        PageRequest pageRequest = JpaUtils.getPageRequest(selectEntity);
        Page<GStoreGoods> data = gStoreGoodsService.findPage(jsonStr, pageRequest);
        List<GStoreGoods> content = data.getContent();
        long total = data.getTotalElements();
        int page = pageRequest.getPageNumber() + 1;
        int size = pageRequest.getPageSize();
        return BaseResult.ok(content, new BaseResult.Result(page, size, total));
    }
//
//    /**
//     * 根据ID查询
//     */
//    @GetMapping(value = "/findIdGStoreGoods")
//    public void findIdGStoreGoods(HttpServletResponse response,@RequestParam Integer id) {
//        GStoreGoods obj = gStoreGoodsService.findId(id);
//        ResponseUtils.responseJsonFilter(response, obj,GStoreGoodsConst.filterselectColumnArr);
//    }
//
//
//    /**
//     * 添加或修改
//     */
//    @PostMapping(value = "/saveGStoreGoods")
//    public void saveGStoreGoods(HttpServletResponse response,@RequestBody GStoreGoods gStoreGoods) {
//        GStoreGoods obj = null;
//        //添加
//        Integer id = gStoreGoods.getId();
//        if (null == id) {
//            //添加
//            log.info("添加:{}", gStoreGoods);
//            WhyBeanUtils.filterField(gStoreGoods, GStoreGoodsConst.filteraddColumnArr);
//            gStoreGoods.setCreatetime(new Date());
//            gStoreGoods.setTid(WhyStringUtil.getUUID());
//            obj = gStoreGoodsService.save(gStoreGoods);
//        } else {
//            //修改
//            log.info("修改:{}", gStoreGoods);
//            GStoreGoods gStoreGoods1 = gStoreGoodsService.findId(id);
//            Assert.notNull(gStoreGoods1, "操作失败！");
//            WhyBeanUtils.filterField(gStoreGoods, GStoreGoodsConst.filteraddColumnArr);
//            obj = gStoreGoodsService.save(gStoreGoods);
//        }
//        ResponseUtils.responseJsonFilter(response, obj,GStoreGoodsConst.filterselectColumnArr);
//    }

    /**
     * 删除
     */
    @PostMapping(value = "/delGStoreGoods")
    public Map delGStoreGoods(@RequestBody Integer idArr[]) {
        gStoreGoodsService.del(idArr);
        return BaseConstants.tableDelSuccess;
    }

}
