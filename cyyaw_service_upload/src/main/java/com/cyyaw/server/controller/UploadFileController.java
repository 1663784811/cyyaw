package com.cyyaw.server.controller;

import com.cyyaw.common.res.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 上传文件
 */
@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadFileController {

    @Value("${web.resources.photo.BaseUrl}")
    private String phtoBaseUrl;

    @Value("${web.resources.photo.uploadPath}")
    private String uploadPath;


    /**
     * 获取操作系统信息
     */
    @PostMapping("/photo")
    public BaseResult photo(MultipartFile file) throws IOException {
        Map<String, Object> map = new HashMap<>();
        if (null != file && file.getSize() > 0) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String filePath = simpleDateFormat.format(date);
            String format = uploadPath + "/" + filePath;
            File dir = new File(format);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Random random = new Random();
            String names = file.getOriginalFilename();
            String fileName = filePath + "/" + random.nextInt(10000) + names;
            String name = uploadPath + "/" + fileName;
            File filePhoto = new File(name);
            FileOutputStream fileOutputStream = new FileOutputStream(filePhoto);
            InputStream inputStream = file.getInputStream();
            int temp;
            while ((temp = inputStream.read()) != (-1)) {
                fileOutputStream.write(temp);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            inputStream.close();
            log.info("上传文件：{}", name);
            map.put("url", phtoBaseUrl + "/" + fileName);
            map.put("path", "/" + fileName);
            map.put("name", names);
            return BaseResult.ok(map, "上传成功");
        } else {
            return BaseResult.fail("上传失败！");
        }
    }


}