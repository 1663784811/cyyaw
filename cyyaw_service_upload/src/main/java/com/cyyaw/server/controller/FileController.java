package com.cyyaw.server.controller;


import com.cyyaw.common.res.BaseResult;
import com.cyyaw.common.util.StringUtilWHY;
import com.cyyaw.server.table.entity.FFile;
import com.cyyaw.server.table.service.FFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/upload")
public class FileController {


    @Autowired
    private FFileService fFileService;


    @RequestMapping("/fileList")
    public BaseResult fileList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "name", required = false) String name
    ) {
        return fFileService.findFileList(page, size, name);
    }

    @PostMapping("/saveFileInfo")
    public BaseResult saveFileInfo(@RequestBody FFile file) {
        if (StringUtilWHY.isEmpty(file.getTid())) {
            file.setTid(StringUtilWHY.getUUID());
        }
        FFile save = fFileService.save(file);
        return BaseResult.ok(save);
    }

    @PostMapping("/delFileInfo")
    public BaseResult delFileInfo(@RequestBody FFile file) {
        fFileService.del(file.getId());
        return BaseResult.ok();
    }
}
