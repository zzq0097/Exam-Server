package com.zyg.exam.service.impl;

import com.zyg.exam.common.ResDTO;
import com.zyg.exam.dao.PaperDao;
import com.zyg.exam.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;
    @Override
    public ResDTO selectPaper(String courseName, String startTime, String className,Integer pageIndex,Integer pageSize) {
        Map<String,Object> params = new HashMap<>();
        params.put("courseName",courseName);
        params.put("startTime",startTime);
        params.put("className",className);
        params.put("pageIndex",pageIndex);
        params.put("pageSize",pageSize);
        List<Object> papers = new ArrayList<>();
        long count=0;
        int total=0;
        if (className!=null&&!className.isEmpty()){
            papers=paperDao.selectByClass(params).get(0);
            count=(long)paperDao.selectByClass(params).get(1).get(0);
            total=(int)count;
        }else {
            papers=paperDao.selectPaper(params).get(0);
            count=(long)paperDao.selectPaper(params).get(1).get(0);
            total=(int)count;
        }
        return new ResDTO(papers,total);
    }
}
