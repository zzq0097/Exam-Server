package com.zyg.exam.service;

import com.zyg.exam.common.ResVO;



public interface  RecordService {
    ResVO selectRecordByUserName(String name, Integer pageIndex, Integer pageSize, String courseName, String className);

    String selectMonitor(Integer recordId);
}
