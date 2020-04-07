package com.zyg.exam.service;

import com.zyg.exam.common.DTO.CorrectPaperDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;

import java.util.List;


public interface  RecordService {
    ResVO selectRecordByUserName(String name, Integer pageIndex, Integer pageSize, String courseName, String className);

    String selectMonitor(Integer recordId);

    JsonBean correctPaper(CorrectPaperDTO correctPaperDTO);
}
