package com.cyyaw.server.controller;

import com.cyyaw.common.entity.SelectEntity;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.common.jpa.JpaUtils;
import com.cyyaw.server.table.entity.EStore;
import com.cyyaw.server.table.service.EStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/store/admin/store")
@RestController
public class StoreController {

    @Autowired
    private EStoreService eStoreService;

    /**
     * 分页条件查询
     */
    @GetMapping(value = "/findPage")
    public BaseResult findPage(String jsonStr, SelectEntity selectEntity) {
        PageRequest pageRequest = JpaUtils.getPageRequest(selectEntity);
        Page<EStore> data = eStoreService.findPage(jsonStr, pageRequest);
        List<EStore> content = data.getContent();
        long total = data.getTotalElements();
        int page = pageRequest.getPageNumber() + 1;
        int size = pageRequest.getPageSize();
        return BaseResult.ok(content, new BaseResult.Result(page, size, total));
    }

    /**
     * 添加或修改
     */
    @PostMapping(value = "/saveStore")
    public BaseResult saveStore(@RequestBody EStore eStore) {
        String tid = eStore.getTid();
        if (StringUtilWHY.isEmpty(tid)) {
            eStore.setTid(StringUtilWHY.getUUID());
        }
        EStore store = eStoreService.save(eStore);
        return BaseResult.ok(store);
    }

}
