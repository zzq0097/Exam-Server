package com.zyg.exam.dao;

import com.zyg.exam.model.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PaperDao {
    int deleteByPrimaryKey(int[] paperids);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer paperid);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);

    List<List<Object>> selectPaper(Map<String,Object> params);

    List<List<Object>> selectByClass(Map<String,Object> params);

    List<List<Object>> selectQuestion(Map<String,Object> params);

    int  insertPaperQuestion(Integer questionid,Integer paperid);
}