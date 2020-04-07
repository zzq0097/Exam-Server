package com.zyg.exam.dao;

import com.zyg.exam.model.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface AnswerDao {
    int insert(Answer record);

    int insertSelective(Answer record);

    Integer selectObjectiveCredit(int recordid);

    int correctObject(int recordid,int questionid,int credit);
}