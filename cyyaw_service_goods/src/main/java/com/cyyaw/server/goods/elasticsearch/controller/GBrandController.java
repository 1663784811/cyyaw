package com.cyyaw.server.goods.elasticsearch.controller;


import com.cyyaw.common.entity.SelectEntity;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.common.jpa.JpaUtils;
import com.cyyaw.server.goods.table.entity.GBrand;
import com.cyyaw.server.goods.table.service.GBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public BaseResult findPage(String jsonStr,  SelectEntity selectEntity) {
        PageRequest pageRequest = JpaUtils.getPageRequest(selectEntity);
        Page<GBrand> data = gBrandService.findPage(jsonStr, pageRequest);
        List<GBrand> content = data.getContent();
        long total = data.getTotalElements();
        int page = pageRequest.getPageNumber() + 1;
        int size = pageRequest.getPageSize();
        return BaseResult.ok(content, new BaseResult.Result(page, size, total));
    }

//    /**
//     * 根据ID查询
//     */
//    @GetMapping(value = "/findIdGBrand")
//    public void findIdGBrand(HttpServletResponse response,@RequestParam Integer id) {
//        GBrand obj = gBrandService.findId(id);
//        ResponseUtils.responseJsonFilter(response, obj,GBrandConst.filterselectColumnArr);
//    }
//
//
//    /**
//     * 添加或修改
//     */
//    @PostMapping(value = "/saveGBrand")
//    public void saveGBrand(HttpServletResponse response,@RequestBody GBrand gBrand) {
//        GBrand obj = null;
//        //添加
//        Integer id = gBrand.getId();
//        if (null == id) {
//            //添加
//            log.info("添加:{}", gBrand);
//            WhyBeanUtils.filterField(gBrand, GBrandConst.filteraddColumnArr);
//            gBrand.setCreatetime(new Date());
//            gBrand.setTid(WhyStringUtil.getUUID());
//            obj = gBrandService.save(gBrand);
//        } else {
//            //修改
//            log.info("修改:{}", gBrand);
//            GBrand gBrand1 = gBrandService.findId(id);
//            Assert.notNull(gBrand1, "操作失败！");
//            WhyBeanUtils.filterField(gBrand, GBrandConst.filteraddColumnArr);
//            obj = gBrandService.save(gBrand);
//        }
//        ResponseUtils.responseJsonFilter(response, obj,GBrandConst.filterselectColumnArr);
//    }
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
