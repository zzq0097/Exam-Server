package com.zyg.exam.service.impl;

import com.zyg.exam.common.ResVO;
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
    @Override
    public ResVO selectRecordByUserName(String name, Integer pageIndex, Integer pageSize, String courseName, String className) {
        Map<String,Object> params = new HashMap<>();
        params.put("name",name);
        params.put("pageIndex",pageIndex);
        params.put("pageSize",pageSize);
        params.put("courseName",courseName);
        params.put("className",className);
        List<Object> records = new ArrayList<>();
        long count = 0;
        if (courseName!=null&&!courseName.isEmpty()){
            System.out.println("courseName");
            records=recordDao.selectByCourse(params).get(0);
            System.out.println(records);
            count=(long)recordDao.selectByCourse(params).get(1).get(0);
        }else if (name!=null&&!name.isEmpty()){
            records=recordDao.selectByUserId(params).get(0);
            count=(long)recordDao.selectByUserId(params).get(1).get(0);
        }else if (className!=null&&!className.isEmpty()){
            records=recordDao.selectByClass(params).get(0);
            count=(long)recordDao.selectByClass(params).get(1).get(0);
        }
        return new ResVO(records,count);
    }

    @Override
    public String selectMonitor(Integer recordId) {
        return recordDao.selectMonitor(recordId);
    }
}
