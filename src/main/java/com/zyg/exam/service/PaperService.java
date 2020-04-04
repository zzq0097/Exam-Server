package com.zyg.exam.service;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.model.Paper;

public interface PaperService {
    ResVO selectPaper(String courseName, String startTime, String className, Integer pageIndex, Integer pageSize);

    JsonBean deletePaper(Integer paperId);

    ResVO selectQuestion(Integer paperId, Integer pageIndex, Integer pageSize);

    JsonBean updatePaper(Paper paper);
}
