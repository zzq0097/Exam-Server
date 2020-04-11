package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.CorrectPaperDTO;
import com.zyg.exam.common.DTO.CreditDTO;
import com.zyg.exam.common.DTO.PaperQuestionDTO;
import com.zyg.exam.common.DTO.RecordDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.dao.AnswerDao;
import com.zyg.exam.dao.QuestionDao;
import com.zyg.exam.dao.RecordDao;
import com.zyg.exam.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;
    @Autowired
    private AnswerDao answerDao;
    @Autowired
    private QuestionDao questionDao;
    @Override
    public ResVO selectRecordByUserName(RecordDTO recordDTO) {
        System.out.println(recordDTO);
      Integer courseid=recordDTO.getCourseid();
      Integer classid=recordDTO.getClassid();
      String name=recordDTO.getName();
        List<Object> records = new ArrayList<>();
        long count = 0;
        int total=0;
        if (courseid!=null){
            System.out.println("courseName");
            records=recordDao.selectByCourse(recordDTO).get(0);
            System.out.println(records);
            count=(long)recordDao.selectByCourse(recordDTO).get(1).get(0);
            total=(int)count;
        }else if (name!=null&&!name.isEmpty()){
            records=recordDao.selectByUserId(recordDTO).get(0);
            count=(long)recordDao.selectByUserId(recordDTO).get(1).get(0);
            total=(int)count;
        }else if (classid!=null){
            records=recordDao.selectByClass(recordDTO).get(0);
            count=(long)recordDao.selectByClass(recordDTO).get(1).get(0);
            total=(int)count;
        }else {
            records=recordDao.listRecord(recordDTO).get(0);
            count=(long)recordDao.listRecord(recordDTO).get(1).get(0);
            total=(int)count;
        }
        return new ResVO(records,total);
    }

    @Override
    public String selectMonitor(Integer recordId) {
        return recordDao.selectMonitor(recordId);
    }

    @Override
    public JsonBean correctPaper( CorrectPaperDTO correctPaperDTO) {
       List<CreditDTO>  lists = correctPaperDTO.getCreditDTOS();
        for (CreditDTO creditDTO:lists){
            answerDao.correctObject(correctPaperDTO.getRecordid(),creditDTO.getQuestionid(),creditDTO.getCredit());
        }
        int grade = answerDao.selectObjectiveCredit(correctPaperDTO.getRecordid());

        int num = recordDao.setGrade(correctPaperDTO.getRecordid(),grade);
        if (num>0){
            return new JsonBean(200,"批改",null);
        }else {
            return new JsonBean(500,"批改失败",null);
        }
    }

    @Override
    public ResVO selectQuestionByRecord(PaperQuestionDTO paperQuestionDTO) {
        List<Object> questions = questionDao.selectByRecord(paperQuestionDTO).get(0);
        long count =(long) questionDao.selectByRecord(paperQuestionDTO).get(1).get(0);
        int total = (int)count;
        return new ResVO(questions,total);
    }
}
