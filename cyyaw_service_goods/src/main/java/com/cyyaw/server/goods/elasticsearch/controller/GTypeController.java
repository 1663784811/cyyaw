package com.cyyaw.server.goods.elasticsearch.controller;


import com.cyyaw.common.entity.SelectEntity;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.ResponseUtils;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.common.jpa.JpaUtils;
import com.cyyaw.server.common.jpa.WhyBeanUtils;
import com.cyyaw.server.goods.table.entity.GType;
import com.cyyaw.server.goods.table.service.GTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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


    /**
     * 添加或修改
     */
    @RequestMapping(value = "/saveType")
    public BaseResult saveType(@RequestBody GType gType) {
        GType type = gTypeService.saveType(gType);
        return BaseResult.ok(type);
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
