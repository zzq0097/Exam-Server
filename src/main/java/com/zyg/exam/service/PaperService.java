package com.zyg.exam.service;

import com.zyg.exam.common.ResDTO;

import java.util.Date;

public interface PaperService {
    ResDTO selectPaper(String courseName, String startTime,String className,Integer pageIndex,Integer pageSize);
}
