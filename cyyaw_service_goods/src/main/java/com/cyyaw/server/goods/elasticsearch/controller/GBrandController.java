package com.cyyaw.server.goods.elasticsearch.controller;


import com.cyyaw.common.entity.SelectEntity;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.ResponseUtils;
import com.cyyaw.server.common.jpa.JpaUtils;
import com.cyyaw.server.common.jpa.WhyBeanUtils;
import com.cyyaw.server.goods.table.entity.GBrand;
import com.cyyaw.server.goods.table.entity.GType;
import com.cyyaw.server.goods.table.service.GBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RequestMapping("/goods/brand")
@RestController
public class GBrandController {

    @Autowired
    private GBrandService gBrandService;

    /**
     * 分页条件查询
     */
    @GetMapping(value = "/findPage")
    public BaseResult findPage(String jsonStr, SelectEntity selectEntity) {
        PageRequest pageRequest = JpaUtils.getPageRequest(selectEntity);
        Page<GBrand> data = gBrandService.findPage(jsonStr, pageRequest);
        List<GBrand> content = data.getContent();
        long total = data.getTotalElements();
        int page = pageRequest.getPageNumber() + 1;
        int size = pageRequest.getPageSize();
        return BaseResult.ok(content, new BaseResult.Result(page, size, total));
    }

    /**
     * 添加或修改
     */
    @PostMapping(value = "/saveBrand")
    public BaseResult saveBrand(@RequestBody GBrand gBrand) {
        GBrand brand = gBrandService.saveBrand(gBrand);
        return BaseResult.ok(brand);
    }
//
//    /**
//     * 删除
//     */
//    @PostMapping(value = "/delGBrand")
//    public Map delGBrand( @RequestBody Integer idArr[]) {
//        gBrandService.del(idArr);
//        return BaseConstants.tableDelSuccess;
//    }

}
