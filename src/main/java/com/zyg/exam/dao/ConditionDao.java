package com.zyg.exam.dao;

import com.zyg.exam.model.Condition;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionDao {
    int insert(Condition record);

    int insertSelective(Condition record);
}