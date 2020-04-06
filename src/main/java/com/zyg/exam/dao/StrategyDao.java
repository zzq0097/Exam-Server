package com.zyg.exam.dao;

import com.zyg.exam.model.Strategy;
import org.springframework.stereotype.Repository;

@Repository
public interface StrategyDao {
    int deleteByPrimaryKey(Integer strategyid);

    int insert(Strategy record);

    int insertSelective(Strategy record);

    Strategy selectByPrimaryKey(Integer strategyid);

    int updateByPrimaryKeySelective(Strategy record);

    int updateByPrimaryKey(Strategy record);
}