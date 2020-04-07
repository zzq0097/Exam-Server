package com.zyg.exam.controller;

import com.zyg.exam.common.DTO.CorrectPaperDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/getRecordList")
    public ResVO selectRecord(String name, Integer pageIndex, Integer pageSize, String courseName, String className){
        return recordService.selectRecordByUserName(name, pageIndex, pageSize,courseName,className);
    }

    @GetMapping("/getMonitor")
    public String selectMonitor(Integer recordId){
        return recordService.selectMonitor(recordId);
    }

    @RequestMapping(value = "/correctObjective", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonBean correctObjective(@RequestBody CorrectPaperDTO correctPaperDTO){
        System.out.println(correctPaperDTO);
        return recordService.correctPaper(correctPaperDTO);
    }
}
