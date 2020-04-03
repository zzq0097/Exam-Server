package com.zyg.exam.service;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResDTO;
import com.zyg.exam.model.Paper;

import java.util.Date;

public interface PaperService {
    ResDTO selectPaper(String courseName, String startTime,String className,Integer pageIndex,Integer pageSize);

    JsonBean deletePaper(Integer paperId);

    ResDTO selectQuestion(Integer paperId,Integer pageIndex,Integer pageSize);

    JsonBean updatePaper(Paper paper);
}
