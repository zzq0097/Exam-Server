package com.zyg.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyg.exam.common.DTO.RecordDTO;
import com.zyg.exam.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RecordDao extends BaseMapper<Record> {
    int deleteByPrimaryKey(Integer recordid);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer recordid);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    List<List<Object>> selectByUserId(RecordDTO recordDTO);

    List<List<Object>> selectByCourse(RecordDTO recordDTO);

    List<List<Object>> selectByClass(RecordDTO recordDTO);

    List<List<Object>> listRecord(RecordDTO recordDTO);

    String selectMonitor(int recordId);

    int setGrade(int recordid,int grade);
}