package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.CorrectPaperDTO;
import com.zyg.exam.common.DTO.CreditDTO;

import com.zyg.exam.common.DTO.RecordDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.common.VO.BarVO;
import com.zyg.exam.common.VO.EverQuestion;
import com.zyg.exam.common.VO.SpreadVO;
import com.zyg.exam.dao.AnswerDao;
import com.zyg.exam.dao.QuestionDao;
import com.zyg.exam.dao.RecordDao;
import com.zyg.exam.model.Class;
import com.zyg.exam.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Transactional(rollbackFor = Exception.class)
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
        long total;
        if (courseid!=null){
            System.out.println("courseName");
            records=recordDao.selectByCourse(recordDTO).get(0);
            System.out.println(records);
            total=(long)recordDao.selectByCourse(recordDTO).get(1).get(0);

        }else if (name!=null&&!name.isEmpty()){
            records=recordDao.selectByUserId(recordDTO).get(0);
            total=(long)recordDao.selectByUserId(recordDTO).get(1).get(0);

        }else if (classid!=null){
            records=recordDao.selectByClass(recordDTO).get(0);
            total=(long)recordDao.selectByClass(recordDTO).get(1).get(0);

        }else {
            records=recordDao.listRecord(recordDTO).get(0);
            total=(long)recordDao.listRecord(recordDTO).get(1).get(0);

        }
        return new ResVO(records,total);
    }

    @Override
    public String selectMonitor(Integer recordId) {
        return recordDao.selectMonitor(recordId);
    }

    @Override
    public JsonBean correctPaper( CorrectPaperDTO correctPaperDTO) {
        //计算客观题分数

        List<Object> stuAnswer = answerDao.correctSubject(correctPaperDTO.getRecordid()).get(0);
        List<Object> answers = answerDao.correctSubject(correctPaperDTO.getRecordid()).get(1);
        //计算正确答题数
        int num1=(int)stuAnswer.stream().filter(answers::contains).count();
        int subjectiveCredit = answerDao.selectValue(correctPaperDTO.getRecordid())*num1;
        //计算主观题分数
       List<CreditDTO>  lists = correctPaperDTO.getCreditDTOS();
        for (CreditDTO creditDTO:lists){
            answerDao.correctObject(correctPaperDTO.getRecordid(),creditDTO.getQuestionid(),creditDTO.getCredit());
        }
        int objectiveCredit = answerDao.selectObjectiveCredit(correctPaperDTO.getRecordid());
        //总分
        int grade=subjectiveCredit+objectiveCredit;
        //插入数据库
        int num =0;
        try {
           recordDao.setGrade(correctPaperDTO.getRecordid(),grade);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if (num>0){
            return new JsonBean(200,"批改",null);
        }else {
            return new JsonBean(500,"批改失败",null);
        }
    }

    @Override
    public JsonBean selectQuestionByRecord(Integer recordid) {
        List<Object> questions = questionDao.selectByRecord(recordid);


        return new JsonBean(200,"",questions);
    }

    @Override
    public List<BarVO> selectAverage(Integer paperid) {
        return recordDao.selectAverage(paperid);
    }

    @Override
    public List<SpreadVO> selectSpread(Integer paperid, Integer classid) {
        return recordDao.selectSpread(paperid,classid);
    }

    @Override
    public List<Class> selectClass(Integer paperid) {
        return recordDao.selectClass(paperid);
    }

    @Override
    public List<EverQuestion> selectEverQues(Integer paperid,Integer classid) {
        return recordDao.selectEverQues(paperid,classid);
    }
}
