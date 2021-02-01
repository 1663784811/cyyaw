package com.cyyaw.server.goods.elasticsearch.controller;


import com.cyyaw.common.entity.SelectEntity;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.common.jpa.JpaUtils;
import com.cyyaw.server.goods.table.entity.GType;
import com.cyyaw.server.goods.table.service.GTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/goods/type")
@RestController
public class GTypeController {

    @Autowired
    private GTypeService gTypeService;


    /**
     * 分页条件查询
     */
    @GetMapping(value = "/findPage")
    public BaseResult findPage(String jsonStr, SelectEntity selectEntity) {
        PageRequest pageRequest = JpaUtils.getPageRequest(selectEntity);
        Page<GType> data = gTypeService.findPage(jsonStr, pageRequest);
        List<GType> content = data.getContent();
        long total = data.getTotalElements();
        int page = pageRequest.getPageNumber() + 1;
        int size = pageRequest.getPageSize();
        return BaseResult.ok(content, new BaseResult.Result(page, size, total));
    }

//    /**
//     * 根据ID查询
//     */
//    @GetMapping(value = "/findIdGType")
//    public void findIdGType(HttpServletResponse response,@RequestParam Integer id) {
//        GType obj = gTypeService.findId(id);
//        ResponseUtils.responseJsonFilter(response, obj,GTypeConst.filterselectColumnArr);
//    }
//
//
//    /**
//     * 添加或修改
//     */
//    @PostMapping(value = "/saveGType")
//    public void saveGType(HttpServletResponse response,@RequestBody GType gType) {
//        GType obj = null;
//        //添加
//        Integer id = gType.getId();
//        if (null == id) {
//            //添加
//            log.info("添加:{}", gType);
//            WhyBeanUtils.filterField(gType, GTypeConst.filteraddColumnArr);
//            gType.setCreatetime(new Date());
//            gType.setTid(WhyStringUtil.getUUID());
//            obj = gTypeService.save(gType);
//        } else {
//            //修改
//            log.info("修改:{}", gType);
//            GType gType1 = gTypeService.findId(id);
//            Assert.notNull(gType1, "操作失败！");
//            WhyBeanUtils.filterField(gType, GTypeConst.filteraddColumnArr);
//            obj = gTypeService.save(gType);
//        }
//        ResponseUtils.responseJsonFilter(response, obj,GTypeConst.filterselectColumnArr);
//    }
//
//    /**
//     * 删除
//     */
//    @PostMapping(value = "/delGType")
//    public Map delGType( @RequestBody Integer idArr[]) {
//        gTypeService.del(idArr);
//        return BaseConstants.tableDelSuccess;
//    }

}
