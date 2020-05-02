package com.zyg.exam.controller;

import com.zyg.exam.common.DTO.CorrectPaperDTO;
import com.zyg.exam.common.DTO.PaperQuestionDTO;
import com.zyg.exam.common.DTO.RecordDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.common.VO.BarVO;
import com.zyg.exam.common.VO.SpreadVO;
import com.zyg.exam.dao.RecordDao;
import com.zyg.exam.model.Class;
import com.zyg.exam.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @RequestMapping("/selectAverage")
    public List<BarVO> selectAverage(Integer paperid){
        return recordService.selectAverage(paperid);
    }

    @RequestMapping("/selectSpread")
    public List<SpreadVO> selectSpread(Integer paperid,Integer classid){
        return recordService.selectSpread(paperid,classid);
    }

    @RequestMapping("/selectClassByPaperid")
    public List<Class> selectClass(Integer paperid){
        return recordService.selectClass(paperid);
    }
}
