package com.zyg.exam.service;

import com.zyg.exam.common.DTO.CorrectPaperDTO;
import com.zyg.exam.common.DTO.PaperQuestionDTO;
import com.zyg.exam.common.DTO.RecordDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.common.VO.BarVO;
import com.zyg.exam.common.VO.EverQuestion;
import com.zyg.exam.common.VO.SpreadVO;
import com.zyg.exam.model.Class;

import java.util.List;


public interface  RecordService {
    ResVO selectRecordByUserName(RecordDTO recordDTO);

    String selectMonitor(Integer recordId);

    JsonBean correctPaper(CorrectPaperDTO correctPaperDTO);

    JsonBean selectQuestionByRecord(Integer recordid);

    List<BarVO> selectAverage(Integer paperid);

    List<SpreadVO> selectSpread(Integer paperid,Integer classid);

    List<Class> selectClass(Integer paperid);

    List<EverQuestion> selectEverQues(Integer paperid,Integer classid);
}
