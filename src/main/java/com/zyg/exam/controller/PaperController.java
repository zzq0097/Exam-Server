package com.zyg.exam.controller;

import com.zyg.exam.common.ResDTO;
import com.zyg.exam.service.PaperService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PaperController {
    @Autowired
    private PaperService paperService;

    @GetMapping("/getPaperList")
    public ResDTO getPaperList(String className, String courseName, String startTime,Integer pageSize,Integer pageIndex){
        return paperService.selectPaper(courseName,startTime,className,pageIndex,pageSize);
    }
}
