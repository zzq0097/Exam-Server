package com.zyg.exam.dao;

import com.zyg.exam.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RecordDao {
    int deleteByPrimaryKey(Integer recordid);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer recordid);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    List<List<Object>> selectByUserId(Map<String,Object> params);

    List<List<Object>> selectByCourse(Map<String,Object> params);

    List<List<Object>> selectByClass(Map<String,Object> params);

    String selectMonitor(int recordId);
}