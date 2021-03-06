package com.zyg.exam.service.impl;

import com.zyg.exam.common.DTO.PaperDTO;
import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.dao.PaperDao;
import com.zyg.exam.dao.QuestionDao;
import com.zyg.exam.model.Paper;
import com.zyg.exam.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Transactional(rollbackFor = Exception.class)
@Slf4j
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;
    @Autowired
    private QuestionDao questionDao;
    @Override
    public ResVO selectPaper(PaperDTO paperDTO) {
        Integer courseid=paperDTO.getCourseid();
        Integer classid=paperDTO.getClassid();
        List<Object> papers=new ArrayList<>();
        long total=0;
        if (classid!=null){
            papers=paperDao.selectByClass(paperDTO).get(0);
            total = (long)paperDao.selectByClass(paperDTO).get(1).get(0);
        }else {
            papers=paperDao.selectPaper(paperDTO).get(0);
            total=(long)paperDao.selectPaper(paperDTO).get(1).get(0);
        }

        return new ResVO(papers,total);
    }

    @Override
    public JsonBean deletePaper(int[] paperids) {
        int num=0;
        try {
            num=paperDao.deleteByPrimaryKey(paperids);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new JsonBean(200,"删除了"+num+"条数据",null);
    }

    @Override
    public ResVO selectQuestion(Integer paperId, Integer pageIndex, Integer pageSize) {
        Map<String,Object> params = new HashMap<>();
        params.put("paperId",paperId);
        params.put("pageIndex",pageIndex);
        params.put("pageSize",pageSize);
        List<Object> questions = paperDao.selectQuestion(params).get(0);
        int total=(int)paperDao.selectQuestion(params).get(1).get(0);
        return new ResVO(questions,total);
    }

    @Override
    public JsonBean updatePaper(Paper paper) {
        System.out.println(paper);
        int num =0;
         try {
             num=paperDao.updateByPrimaryKeySelective(paper);
         }catch (Exception e){
             e.printStackTrace();
             throw new RuntimeException(e);
         }
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"修改成功",null);
        }else {
            return new JsonBean(500,"修改失败",null);
        }
    }

    @Override
    public JsonBean selectQuestions(Integer paperid) {
        List<Object> questions = questionDao.selectByPaperid(paperid);
        return new JsonBean(200,"",questions);
    }
}
