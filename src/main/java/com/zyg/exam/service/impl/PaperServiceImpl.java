package com.zyg.exam.service.impl;

import com.zyg.exam.common.JsonBean;
import com.zyg.exam.common.ResVO;
import com.zyg.exam.dao.PaperDao;
import com.zyg.exam.model.Paper;
import com.zyg.exam.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;
    @Override
    public ResVO selectPaper(String courseName, String startTime, String className, Integer pageIndex, Integer pageSize) {
        Map<String,Object> params = new HashMap<>();
        params.put("courseName",courseName);
        params.put("startTime",startTime);
        params.put("className",className);
        params.put("pageIndex",pageIndex);
        params.put("pageSize",pageSize);
        List<Object> papers;
        long count=0;
        int total=0;
        if (className!=null&&!className.isEmpty()){
            System.out.println(className);
            papers=paperDao.selectByClass(params).get(0);
            System.out.println(paperDao.selectByClass(params));
            System.out.println(papers);
            count=(long)paperDao.selectByClass(params).get(1).get(0);
            total=(int)count;
        }else {
            papers=paperDao.selectPaper(params).get(0);
            count=(long)paperDao.selectPaper(params).get(1).get(0);
            total=(int)count;
        }
        return new ResVO(papers,total);
    }

    @Override
    public JsonBean deletePaper(int[] paperids) {
        return new JsonBean(200,"删除了"+paperDao.deleteByPrimaryKey(paperids)+"条数据",null);
    }

    @Override
    public ResVO selectQuestion(Integer paperId, Integer pageIndex, Integer pageSize) {
        Map<String,Object> params = new HashMap<>();
        params.put("paperId",paperId);
        params.put("pageIndex",pageIndex);
        params.put("pageSize",pageSize);
        List<Object> questions = paperDao.selectQuestion(params).get(0);
        long count = (long)paperDao.selectQuestion(params).get(1).get(0);
        int total=(int)count;
        return new ResVO(questions,total);
    }

    @Override
    public JsonBean updatePaper(Paper paper) {
        System.out.println(paper);
        int num = paperDao.updateByPrimaryKeySelective(paper);
        if (num>0){
            return new JsonBean(HttpStatus.OK.value(),"修改成功",null);
        }else {
            return new JsonBean(500,"修改失败",null);
        }
    }
}
