package com.cyyaw.reptiles.controller;


import com.alibaba.fastjson.JSONObject;
import com.cyyaw.common.res.BaseResult;
import com.cyyaw.reptiles.table.service.RImgService;
import com.cyyaw.reptiles.thread.ThreadMain;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/reptiles")
@RestController
public class ReptilesController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RImgService rImgService;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private ThreadMain threadMain;

    @RequestMapping("/threadInfo")
    public Map<String, JSONObject> threadInfo(){
       Map<String, JSONObject> map = threadMain.getConcurrentMap();
        return map;
    }




    @PostMapping("/person")
    public String save(@RequestBody Person person) {

//        IndexQuery indexQuery = new IndexQueryBuilder()
////                .withId(person.getId().toString())
////                .withObject(person)
////                .build();
////        String documentId = elasticsearchOperations.index(indexQuery);
////        return documentId;
        return null;
    }

    @GetMapping("/person/{id}")
    public Person findById(@PathVariable("id")  Long id) {
        Person person = elasticsearchOperations
                .queryForObject(GetQuery.getById(id.toString()), Person.class);
        return person;
    }



    //=============================================================

    @RequestMapping({"/index"})
    public BaseResult index() {
        return BaseResult.ok();
    }


    @RequestMapping({"/imageList"})
    public BaseResult imageList(
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "100")  Integer size) {
//        Page<RImg> page1 = rImgService.findPage(page, size);
        return BaseResult.ok();
    }


    @RequestMapping({"/sendMessage"})
    public BaseResult sendMessage(String message) {
        rabbitTemplate.convertAndSend("rabbit001", message);
        return BaseResult.ok();
    }

}
