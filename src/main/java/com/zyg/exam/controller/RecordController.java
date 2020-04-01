package com.zyg.exam.controller;

import com.zyg.exam.common.ResDTO;
import com.zyg.exam.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/getRecordList")
    public ResDTO selectRecord(String name,Integer pageIndex,Integer pageSize,String courseName,String className){
        return recordService.selectRecordByUserName(name, pageIndex, pageSize,courseName,className);
    }

    @GetMapping("/getMonitor")
    public String selectMonitor(Integer recordId){
        return recordService.selectMonitor(recordId);
    }

}
