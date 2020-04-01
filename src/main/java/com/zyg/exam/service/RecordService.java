package com.zyg.exam.service;

import com.zyg.exam.common.ResDTO;



public interface  RecordService {
    ResDTO selectRecordByUserName(String name,Integer pageIndex,Integer pageSize,String courseName,String className);

    String selectMonitor(Integer recordId);
}
