package com.zyg.exam.dao;

import com.zyg.exam.model.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Null;
import java.util.List;

@Mapper
@Repository
public interface AnswerDao {
    int insert(Answer record);

    int insertSelective(Answer record);

    Integer selectObjectiveCredit(int recordid);

    int correctObject(int recordid, int questionid, int credit);

    List<List<Object>> correctSubject(Integer recordid);

    int selectValue(Integer recordid);
}