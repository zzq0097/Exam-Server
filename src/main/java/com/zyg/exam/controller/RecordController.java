package com.zyg.exam.controller;

import com.zyg.exam.common.DTO.CorrectPaperDTO;
import com.zyg.exam.common.DTO.RecordDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.dao.RecordDao;
import com.zyg.exam.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecordController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private RecordDao recordDao;

    @RequestMapping("/recordCount")
    public int count(){
        return recordDao.selectCount(null);
    }

    @RequestMapping("/getRecordList")
    public ResVO selectRecord(RecordDTO recordDTO){
        return recordService.selectRecordByUserName(recordDTO);
    }

    @RequestMapping("/getMonitor")
    public String selectMonitor(Integer recordId){
        return recordService.selectMonitor(recordId);
    }

    @RequestMapping(value = "/correctObjective", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonBean correctObjective(@RequestBody CorrectPaperDTO correctPaperDTO){
        System.out.println(correctPaperDTO);
        return recordService.correctPaper(correctPaperDTO);
    }
    @RequestMapping("/selectQuestionByRecord")
    public JsonBean selectQuestionByRecord(Integer recordid){
        return recordService.selectQuestionByRecord(recordid);
    }

    @RequestMapping("/insertWord")
    public void insertWord(Integer paperid){
        recordService.insertWord(paperid);
    }

    @RequestMapping("/largePaper")
    public void largePaper(Integer paperid){
        recordService.largePaper(paperid);
    }
}
