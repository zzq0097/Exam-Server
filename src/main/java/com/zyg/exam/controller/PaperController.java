package com.zyg.exam.controller;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Paper;
import com.zyg.exam.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PaperController {
    @Autowired
    private PaperService paperService;

    @GetMapping("/getPaperList")
    public ResVO getPaperList(String className, String courseName, String startTime, Integer pageSize, Integer pageIndex){
        return paperService.selectPaper(courseName,startTime,className,pageIndex,pageSize);
    }

    @PostMapping("/deletePaper")
    public JsonBean deletePaper(Integer paperId){
        return paperService.deletePaper(paperId);
    }

    @GetMapping("/listQuestion")
    public ResVO selectQuestion(Integer paperId, Integer pageIndex, Integer pageSize){
        return paperService.selectQuestion(paperId,pageIndex,pageSize);
    }

    @PutMapping("/updateQuestion")
    public JsonBean updatePaper(Paper paper){
        return paperService.updatePaper(paper);
    }
}
