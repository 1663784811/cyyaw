package com.cyyaw.server.controller;


import com.cyyaw.common.entity.SelectEntity;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.server.common.jpa.JpaUtils;
import com.cyyaw.server.table.entity.EEnterprise;
import com.cyyaw.server.table.service.EEnterpriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/store/admin/enterprise")
@RestController
public class EEnterpriseController {

    @Autowired
    private EEnterpriseService eEnterpriseService;

    /**
     * 分页条件查询
     */
    @GetMapping(value = "/findPage")
    public BaseResult findPage(String jsonStr,  SelectEntity selectEntity) {
        PageRequest pageRequest = JpaUtils.getPageRequest(selectEntity);
        Page<EEnterprise> data = eEnterpriseService.findPage(jsonStr, pageRequest);
        List<EEnterprise> content = data.getContent();
        long total = data.getTotalElements();
        int page = pageRequest.getPageNumber() + 1;
        int size = pageRequest.getPageSize();
        return BaseResult.ok(content, new BaseResult.Result(page, size, total));
    }


    /**
     * 添加或修改
     */
    @PostMapping(value = "/saveEEnterprise")
    public BaseResult saveEEnterprise(@RequestBody EEnterprise eEnterprise) {
        EEnterprise enterprise = eEnterpriseService.saveEnterprise(eEnterprise);
        return BaseResult.ok(enterprise);
    }


    @PostMapping(value = "/delEEnterprise")
    public BaseResult delEEnterprise(@RequestBody List<EEnterprise> list) {
        Integer[] integers = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            integers[i] =  list.get(i).getId();
        }
        eEnterpriseService.del(integers);
        return BaseResult.ok();
    }

}
